package it.quizzy.logiclayer.manager;

import it.quizzy.databaselayer.exceptions.RecordNotFoundException;
import it.quizzy.databaselayer.models.Partita;
import it.quizzy.databaselayer.models.Utente;

public class UtenteManager {
	
	private Utente sessioneUtente;
	
	public UtenteManager(String nickname, String pin, int avatar) {
		
		try {
			Partita p = new Partita(pin);
			this.sessioneUtente=new Utente(nickname,0,p.getRecord().getId(), avatar);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Utente getSessioneUtente() {
		return sessioneUtente;
	}
	
	public String getNickname() {
		return sessioneUtente!=null?sessioneUtente.getRecord().getNickname():null;
	}
	
	public Integer getPunteggio() {
		return sessioneUtente!=null?sessioneUtente.getRecord().getPunteggio():null;
	}
	
	public int getPartitaPort() {
		try {
			Partita p = new Partita(sessioneUtente.getRecord().getIdPartita());
			return p.getRecord().getPort();
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
}
