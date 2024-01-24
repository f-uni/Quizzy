package it.quizzy.databaselayer.models.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import it.quizzy.databaselayer.models.Docente;
import it.quizzy.databaselayer.models.Quiz;
import it.quizzy.databaselayer.models.domande.DomandaRispostaMultipla;
import it.quizzy.databaselayer.models.domande.DomandaVeroFalso;

class QuizTest {

	@Test
	void create() {

		try {
			Docente d = new Docente("Docente Test", "test@test.it", "password");
			Quiz q = new Quiz(d.getRecord().getId(), "Quiz di test");
			Quiz qf=new Quiz(q.getRecord().getId());
			assertEquals(q.getTitolo(), qf.getTitolo());
			assertEquals(q.toString(), qf.toString());
			
			DomandaVeroFalso dom1 = new DomandaVeroFalso(q.getRecord().getId(), "domanda di test?", "vero");
			DomandaRispostaMultipla dom2 = new DomandaRispostaMultipla(q.getRecord().getId(), "domanda di test?", "1",
					Arrays.asList("1", "2", "3", "4"));
			assertEquals(dom1.getDomanda(), q.getDomande().get(0).getDomanda());
			assertEquals(dom2.getDomanda().toString(), q.getDomande().get(1).getDomanda());
			
			dom1.getRecord().delete();
			dom2.getRecord().delete();
			d.getRecord().delete();
			q.getRecord().delete();
			qf.getRecord().delete();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

