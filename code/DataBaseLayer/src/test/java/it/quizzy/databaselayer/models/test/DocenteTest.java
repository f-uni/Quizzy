package it.quizzy.databaselayer.models.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.quizzy.databaselayer.models.Docente;

class DocenteTest {

	@Test
	void create() {
		try {
			Docente d = new Docente("Docente Test", "test@test.it", "password");
			Integer id= d.getRecord().getId();
			Docente df=new Docente(id);
			assertEquals(d.getRecord().getEmail(), df.getRecord().getEmail());
			
			Docente de = new Docente("test@test.it");
			assertEquals("Docente Test", de.getRecord().getNomeCompleto());
			
			Docente di = new Docente(77);
			assertEquals(77, di.getRecord().getId());
			
			Docente din = new Docente(-1);
			assertNotEquals(77, din.getRecord().getId());
			
			d.getRecord().delete();
			de.getRecord().delete();
			di.getRecord().delete();
			din.getRecord().delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void getters() {
		
		try {
			
			Docente d = new Docente("nome", "email@email.it", "password");
//			Quiz q = new Quiz(d.getRecord().getId(), "quiz di prova");
			
			assertEquals(true, d.creaQuiz("Quiz di prova"));

			assertEquals("Quiz di prova", d.getQuizzies().get(0).getTitolo());

			assertEquals(d.toString(), d.getRecord().toString());
			
			d.getRecord().delete();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
