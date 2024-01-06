package it.quizzy.logiclayer.manager;

import it.quizzy.databaselayer.exceptions.RecordNotFoundException;
import it.quizzy.databaselayer.models.Docente;
import it.quizzy.databaselayer.util.StringHash;

public class DocenteManager {
	Docente sessioneDocente;
	
	public DocenteManager() {}
	
	public boolean login(String email, String password) {
		Docente d;
		try {
			d = new Docente(email);
			if(StringHash.hash(password).equals(d.record.getPasswordHash())) {
				this.sessioneDocente=d;
				return true;
			}
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean isLogged() {
		return sessioneDocente!=null;
	}
}