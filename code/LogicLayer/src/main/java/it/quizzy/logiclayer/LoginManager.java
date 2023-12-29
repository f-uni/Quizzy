package it.quizzy.logiclayer;

import it.quizzy.databaselayer.exceptions.RecordNotFoundException;
import it.quizzy.databaselayer.models.Docente;
import it.quizzy.databaselayer.util.StringHash;

public class LoginManager {
	Docente sessioneDocente;
	
	public LoginManager() {}
	
	public boolean login(String email, String password) {
		Docente d;
		try {
			d = new Docente(email);
			if(StringHash.hash(password).equals(d.record.getPasswordHash())) {
				this.sessioneDocente=d;
				return true;
			}
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean isLogged() {
		return sessioneDocente!=null;
	}
}