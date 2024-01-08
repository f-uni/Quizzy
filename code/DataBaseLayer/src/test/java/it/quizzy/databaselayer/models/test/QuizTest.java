package it.quizzy.databaselayer.models.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.quizzy.databaselayer.models.Docente;
import it.quizzy.databaselayer.models.Quiz;

class QuizTest {

	@Test
	void create() {

		try {
			Docente d = new Docente("Docente Test", "test@test.it", "password");
			Quiz q = new Quiz(d.getRecord().getId(), "Quiz di test");
			Quiz qf=new Quiz(q.getRecord().getId());
			assertEquals(q.getRecord().getTitolo(), qf.getRecord().getTitolo());
			d.getRecord().delete();
			q.getRecord().delete();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
