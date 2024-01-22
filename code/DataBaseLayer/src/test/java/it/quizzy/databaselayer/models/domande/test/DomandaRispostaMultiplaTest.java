package it.quizzy.databaselayer.models.domande.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import it.quizzy.databaselayer.models.Docente;
import it.quizzy.databaselayer.models.Quiz;
import it.quizzy.databaselayer.models.domande.DomandaRispostaMultipla;

class DomandaRispostaMultiplaTest {

	@Test
	void create() {
		try {
			Docente d = new Docente("Docente Test", "test@test.it", "password");
			Quiz q = new Quiz(d.getRecord().getId(), "Quiz di test");

			DomandaRispostaMultipla dom = new DomandaRispostaMultipla(q.getRecord().getId(), "domanda di test?", "1",
					Arrays.asList("1", "2", "3", "4"));
			
			DomandaRispostaMultipla domf = new DomandaRispostaMultipla(dom.getRecord().getId());
			
			assertEquals(dom.getDomanda(), domf.getDomanda());
			
			dom.getRecord().delete();
			q.getRecord().delete();
			d.getRecord().delete();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
