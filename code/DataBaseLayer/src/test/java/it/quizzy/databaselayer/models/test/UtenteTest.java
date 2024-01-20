package it.quizzy.databaselayer.models.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.quizzy.databaselayer.models.Docente;
import it.quizzy.databaselayer.models.Partita;
import it.quizzy.databaselayer.models.Quiz;
import it.quizzy.databaselayer.models.Utente;

class UtenteTest {

	@Test
	void create() {

		try {
			Docente d = new Docente("Docente Test", "test@test.it", "password");
			Quiz q = new Quiz(d.getRecord().getId(), "Quiz di test");
			Partita p = new Partita(d.getRecord().getId(), q.getRecord().getId());
			Utente u = new Utente("test nick", 0, p.getRecord().getId(), 1);
			Utente uf=new Utente(u.getRecord().getId());
			assertEquals(u.getRecord().getNickname(), uf.getRecord().getNickname());
			u.getRecord().delete();
			p.getRecord().delete();
			q.getRecord().delete();
			d.getRecord().delete();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
