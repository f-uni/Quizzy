package it.quizzy.logiclayer.manager.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import it.quizzy.databaselayer.exceptions.InvalidRecordInsertionException;
import it.quizzy.databaselayer.models.Quiz;
import it.quizzy.logiclayer.manager.DocenteManager;
import it.quizzy.logiclayer.manager.PartitaManager;
import it.quizzy.logiclayer.manager.QuizManager;
import it.quizzy.logiclayer.manager.UtenteManager;
import it.quizzy.logiclayer.server.ClientDocente;
import it.quizzy.logiclayer.server.ClientUtente;

class PartitaManagerTest {

	@Test
	void test() {
		DocenteManager dm = new DocenteManager();
		dm.login("t@t.it", "password");

		Quiz q;
		try {
			q = new Quiz(dm.getId(), "Quiz di test");
			QuizManager qm = new QuizManager(q);

			qm.aggiungiDomandaVeroFalso("vero o no ?", "vero");
			qm.aggiungiDomandaRispostaMultipla("domanda di test?", "1", Arrays.asList("1", "2", "3", "4"));
			qm.aggiungiDomandaVeroFalso("vero o falso ?", "vero");

			PartitaManager pm = new PartitaManager(dm.getId(), q.getRecord().getId());
			
			ClientDocente cd = new ClientDocente(pm.getServer().getPort(), (String m) -> {
				return null;
			});

			UtenteManager um = new UtenteManager("g1", pm.getPin(), 0);
			ClientUtente client = new ClientUtente(um.getPartitaPort(), um.getSessioneUtente(), (String message) -> {
				System.out.println("Ricevo:" + message);
				return null;
			});
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assertEquals(um.getNickname(), pm.getGiocatori().get(0).getRecord().getNickname());

			pm.prossimaDomanda();
			//rispondo giusto
			pm.rispondiDomanda(um.getSessioneUtente().getRecord().getId(), "vero");
			pm.valutaRisposte();
			pm.calcolaClassifica();

			assertEquals(100, pm.getGiocatori().get(0).getRecord().getPunteggio());

			
			pm.prossimaDomanda();
			//rispondo sbagliato
			pm.rispondiDomanda(um.getSessioneUtente().getRecord().getId(), "2");
			pm.valutaRisposte();
			pm.calcolaClassifica();

			assertEquals(100, pm.getGiocatori().get(0).getRecord().getPunteggio());
			
			//non risponde
			//pm.rispondiDomanda(um.getSessioneUtente().getRecord().getId(), "vero");
			pm.prossimaDomanda();
			pm.valutaRisposte();
			pm.calcolaClassifica();

			assertEquals(100, pm.getGiocatori().get(0).getRecord().getPunteggio());
			
			pm.getServer().stopPartita();

		} catch (InvalidRecordInsertionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
