package it.quizzy.logiclayer.manager;

import it.quizzy.databaselayer.exceptions.InvalidRecordInsertionException;
import it.quizzy.databaselayer.models.Utente;

public class UtenteManager {
	
	private Utente sessioneUtente;
	
	public UtenteManager() {}
	
	public boolean login(String nickname, int idPartita) {
		try {
			this.sessioneUtente=new Utente(nickname,0,idPartita);
			return true;
		} catch (InvalidRecordInsertionException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public String getNickname() {
		return sessioneUtente!=null?sessioneUtente.getRecord().getNickname():null;
	}
	
	public Integer getPunteggio() {
		return sessioneUtente!=null?sessioneUtente.getRecord().getPunteggio():null;
	}
	
	
}
