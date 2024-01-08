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
			Quiz q = new Quiz(d.record.getId(), "Quiz di test");

			DomandaVeroFalso dom = new DomandaVeroFalso(q.record.getId(), "domanda di test?", "vero");

			DomandaVeroFalso domf = new DomandaVeroFalso(dom.record.getId());

			assertEquals(dom.getDomanda(), domf.getDomanda());

			dom.record.delete();
			q.record.delete();
			d.record.delete();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
