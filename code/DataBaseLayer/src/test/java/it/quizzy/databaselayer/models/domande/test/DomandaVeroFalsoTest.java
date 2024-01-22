package it.quizzy.databaselayer.models.domande.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.quizzy.databaselayer.models.Docente;
import it.quizzy.databaselayer.models.Quiz;
import it.quizzy.databaselayer.models.domande.DomandaVeroFalso;

class DomandaVeroFalsoTest {

	@Test
	void create() {
		try {
			Docente d = new Docente("Docente Test", "test@test.it", "password");
			Quiz q = new Quiz(d.getRecord().getId(), "Quiz di test");

			DomandaVeroFalso dom = new DomandaVeroFalso(q.getRecord().getId(), "domanda di test?", "vero");

			DomandaVeroFalso domf = new DomandaVeroFalso(dom.getRecord().getId());

			assertEquals(dom.getDomanda(), domf.getDomanda());

			dom.getRecord().delete();
			q.getRecord().delete();
			d.getRecord().delete();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
