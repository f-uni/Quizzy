package it.quizzy.logiclayer.manager;

import java.util.ArrayList;
import java.util.List;

import it.quizzy.databaselayer.exceptions.RecordNotFoundException;
import it.quizzy.databaselayer.models.Domanda;
import it.quizzy.databaselayer.models.Partita;
import it.quizzy.databaselayer.models.Quiz;
import it.quizzy.databaselayer.models.Utente;
import it.quizzy.logiclayer.ServerPartita;

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
	
	public PartitaManager(Partita partita) {
		try {
			this.partita=partita;
			this.quiz=new Quiz(this.partita.getRecord().getIdQuiz());
			this.domande=this.quiz.getDomande();
			this.giocatori=new ArrayList<>();
			this.domandaCorrente=0;
			
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void calcolaClassifica(){
		this.giocatori.sort((g1,g2) -> g1.getRecord().getPunteggio()-g2.getRecord().getPunteggio());
	}
	
	
	public String prossimaDomanda() {
		
		
		
		this.domandaCorrente++;
		if(this.domande.size()<domandaCorrente)
			return this.domande.get(domandaCorrente-1).getDomanda();
		else
			return "";
	}
	
	public boolean aggiungiGiocatore(Utente giocatore) {
		if(giocatore.getRecord().getIdPartita()==this.partita.getRecord().getId()) {
			this.giocatori.add(giocatore);
		}
		return false;
	}
	
	
	
	
	
	
}
