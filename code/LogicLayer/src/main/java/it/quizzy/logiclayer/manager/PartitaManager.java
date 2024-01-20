package it.quizzy.logiclayer.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jooq.tools.json.JSONObject;

import it.quizzy.databaselayer.exceptions.RecordNotFoundException;
import it.quizzy.databaselayer.models.Domanda;
import it.quizzy.databaselayer.models.Partita;
import it.quizzy.databaselayer.models.Quiz;
import it.quizzy.databaselayer.models.Utente;
import it.quizzy.logiclayer.server.ClientDocente;
import it.quizzy.logiclayer.server.ServerPartita;

/**
 * Gestisce gestione/creazione di una partita da parte del docente
 */
public class PartitaManager {
	private Partita partita;
	private Quiz quiz;
	private int domandaCorrente;
	private List<Utente> giocatori;
	private List<Domanda> domande;
	private ServerPartita server;
	private ClientDocente docenteSocket;
	private HashMap<Integer, String> risposte;

	public PartitaManager(int idDocente, int idQuiz) {
		try {
			this.partita = new Partita(idDocente, idQuiz);
			System.out.println("Avvio Partita " + this.partita.getRecord().getId());
			this.quiz = new Quiz(this.partita.getRecord().getIdQuiz());
			this.domande = this.quiz.getDomande();
			this.giocatori = new ArrayList<>();
			this.risposte = new HashMap<>();
			this.domandaCorrente = 0;
			this.server = new ServerPartita((Integer id) -> {
				try {
					return this.aggiungiGiocatore(new Utente(id));
				} catch (RecordNotFoundException e) {
					e.printStackTrace();
				}
				return false;
			}, (Integer idUtente, String risposta) -> {
				this.rispondiDomanda(idUtente, risposta);
				return null;
			});
			this.partita.setSocketPort(server.getPort());
			server.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void calcolaClassifica() {
		this.giocatori.sort((g1, g2) -> g2.getRecord().getPunteggio() - g1.getRecord().getPunteggio());
	}

	public void valutaRisposte() {
		for (String s : risposte.values()) {
			System.err.println(s);
		}
		if (!risposte.isEmpty()) {
			Domanda domanda = this.domande.get(domandaCorrente - 1);
			for (Utente u : giocatori) {
				JSONObject jo = new JSONObject();
				String risp = risposte.get(u.getRecord().getId());
				if (risp != null) {
					if (domanda.controllaRisposta(risp)) {
						u.aggiungiPunti(100);
						jo.put("punti", u.getRecord().getPunteggio());
						server.utenteMessage(u.getRecord().getId(), "risposta_corretta$" + jo.toString());
					} else {
						jo.put("punti", u.getRecord().getPunteggio());
						server.utenteMessage(u.getRecord().getId(), "risposta_errata$" + jo.toString());
					}
				} else {
					jo.put("punti", u.getRecord().getPunteggio());
					server.utenteMessage(u.getRecord().getId(), "risposta_errata$" + jo.toString());
				}
			}
			risposte.clear();
		}
	}

	public String prossimaDomanda() {
		this.domandaCorrente++;
		if (this.domande.size() >= domandaCorrente) {
			Domanda domanda = this.domande.get(domandaCorrente - 1);
			JSONObject jo = new JSONObject();
			jo.put("domanda", domanda.getDomanda());
			jo.put("risposte", domanda.getRisposteDisponibili());

			this.server
					.broadcastMessage("new_domanda_" + domanda.getRecord().getTipo().toString() + "$" + jo.toString());
			return domanda.getDomanda();
		}
		return null;
	}

	public boolean aggiungiGiocatore(Utente giocatore) {
		if (giocatore.getRecord().getIdPartita() == this.partita.getRecord().getId()) {
			JSONObject jo = new JSONObject();
			jo.put("nickname", giocatore.getRecord().getNickname());
			jo.put("avatar", giocatore.getRecord().getAvatar());
			server.messageDocente("new_player$" + jo.toString());
			return this.giocatori.add(giocatore);
		}
		return false;
	}

	public int getDomandaCorrente() {
		return domandaCorrente;
	}

	public ServerPartita getServer() {
		return server;
	}
	
	public String getPin() {
		return partita.getRecord().getPin();
	}

	public List<Utente> getGiocatori() {
		return giocatori;
	}

	public void aggiungiDocente(ClientDocente clientDocente) {
		this.docenteSocket = clientDocente;
	}

	public void rispondiDomanda(Integer idUtente, String risposta) {
		if (this.domande.size() >= domandaCorrente) {
			for (Utente u : giocatori) {
				if (u.getRecord().getId().equals(idUtente)) {
					risposte.put(idUtente, risposta);
					break;
				}
			}
		}

	}

}
