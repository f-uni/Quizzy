package it.quizzy.logiclayer.manager.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import it.quizzy.databaselayer.models.Docente;
import it.quizzy.databaselayer.models.Quiz;
import it.quizzy.databaselayer.models.Domanda;
import it.quizzy.logiclayer.manager.QuizManager;

class QuizManagerTest {

	@Test
	void editQuiz() {
		Docente d;
		try {
			d = new Docente("Docente Test", "test@test.it", "password");
			Quiz q = new Quiz(d.record.getId(), "Quiz di test");
			
			QuizManager qm = new QuizManager(q);
			
			qm.aggiungiDomandaVeroFalso("vero o no ?", "vero");
			qm.aggiungiDomandaRispostaMultipla( "domanda di test?", "1",
					Arrays.asList("1", "2", "3", "4"));
			qm.aggiungiDomandaVeroFalso("vero o falso ?", "vero");
			
			List<Domanda> domande = q.getDomande();
			
			System.out.println(domande);
			
			assertEquals(3, domande.size());
		
			
			int deleteId=domande.get(1).record.getId();
			
			qm.rimuoviDomanda(deleteId);
			
			domande = q.getDomande();
			assertEquals(2,domande.size());

			assertEquals(domande.get(1).record.getNumeroDomanda(), 2);
			

			System.out.println(domande);
			
			for(Domanda dom : domande)
				dom.record.delete();
			
			q.record.delete();
			d.record.delete();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
