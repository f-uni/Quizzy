package it.quizzy.logiclayer.manager.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.quizzy.databaselayer.exceptions.InvalidRecordInsertionException;
import it.quizzy.databaselayer.exceptions.RecordNotFoundException;
import it.quizzy.databaselayer.models.Docente;
import it.quizzy.databaselayer.models.Quiz;
import it.quizzy.logiclayer.manager.DocenteManager;

class DocenteManagerTest {

	@Test
	void login() {
		DocenteManager lm = new DocenteManager();
		lm.login("test@test.it", "password");
		assertTrue(lm.isLogged());
	}

	@Test
	void failedLogin() {
		DocenteManager lm = new DocenteManager();
		lm.login("test@test.it", "passwordsbagliata");
		assertFalse(lm.isLogged());
	}
	
	@Test
	void signUp() {
		String nome = "Docente Test";
		String email = "test@manager1.it";
		String password = "password";
		
		DocenteManager lm = new DocenteManager();
		lm.signUp(nome, email, password);
		lm.login(email, password);
		
		assertTrue(lm.isLogged());
		
		try {
			Docente d = new Docente(email);
			d.getRecord().delete();
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Test
	void settersAndGetters() {
		DocenteManager lm = new DocenteManager();
		try {
			String nome = "Docente Test";
			String email = "test@manager2.it";
			String password = "password";
			
			Docente d = new Docente(nome, email, password);
			lm.login(email, password);
			assertTrue(lm.isLogged());
			
			String titolo = "Quiz test";

			Quiz q = new Quiz(lm.getId(), titolo);
			lm.addQuiz(q.getTitolo());

			assertEquals(titolo, lm.getQuizzies().get(0).getTitolo());
			assertEquals(d.getRecord().getNomeCompleto(), lm.getNome());

			Docente d1 = new Docente(email);

			
			d.getRecord().delete();
			q.getRecord().delete();
			d1.getRecord().delete();
		} catch (InvalidRecordInsertionException e) {
			e.printStackTrace();
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
