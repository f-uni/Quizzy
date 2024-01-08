package it.quizzy.logiclayer.manager;

import it.quizzy.databaselayer.exceptions.RecordNotFoundException;
import it.quizzy.databaselayer.models.Docente;
import it.quizzy.databaselayer.util.StringHash;

/**
 * Gestisce la sessione (login) del docente
 */
public class DocenteManager {
	Docente sessioneDocente;
	
	public DocenteManager() {}
	
	/**
	 * Controlla se l'email e la password sono corrette per eseguire il login del docente e crea la sessione attiva
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public boolean login(String email, String password) {
		Docente d;
		try {
			d = new Docente(email);
			if(StringHash.hash(password).equals(d.getRecord().getPasswordHash())) {
				this.sessioneDocente=d;
				return true;
			}
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean signUp(String nome, String email, String password) {
		Docente d;
		try {
			d = new Docente(nome, email, password);
			this.sessioneDocente=d;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	/**
	 * Controlla se la sessione è attiva, quindi se docente è loggato
	 * 
	 * @return
	 */
	public boolean isLogged() {
		return sessioneDocente!=null;
	}
	
	public String getNome() {
		return sessioneDocente!=null?sessioneDocente.getRecord().getNomeCompleto():null;
	}
	
	public boolean addQuiz(String titolo) {
		if(this.sessioneDocente!=null) {
			return this.sessioneDocente.creaQuiz(titolo);
		}
		return false;
	}
}