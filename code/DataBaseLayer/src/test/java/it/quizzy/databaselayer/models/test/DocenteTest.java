package it.quizzy.databaselayer.models.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.quizzy.databaselayer.models.Docente;

class DocenteTest {

	@Test
	void create() {
		try {
			Docente d1 = new Docente("Docente Test", "luca@carlo.it", "password");
			Docente d2 = new Docente(d1.getRecord().getId());

			assertEquals(d1.getRecord().getEmail(), d2.getRecord().getEmail());

			Docente de = new Docente("luca@carlo.it");
			assertEquals("Docente Test", de.getRecord().getNomeCompleto());

			d1.getRecord().delete();
			d2.getRecord().delete();
			de.getRecord().delete();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	void getters() {
		
		try {
			
			Docente d = new Docente("nome", "email@email.it", "password");
			
			d.creaQuiz("Quiz di prova");

			assertEquals("Quiz di prova", d.getQuizzies().get(0).getTitolo());

			assertEquals(d.toString(), d.getRecord().toString());
			
			d.getRecord().delete();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
