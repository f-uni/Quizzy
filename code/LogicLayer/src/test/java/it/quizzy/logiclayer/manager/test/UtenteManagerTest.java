package it.quizzy.logiclayer.manager.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.quizzy.databaselayer.exceptions.InvalidRecordInsertionException;
import it.quizzy.databaselayer.exceptions.RecordNotFoundException;
import it.quizzy.databaselayer.models.Docente;
import it.quizzy.databaselayer.models.Quiz;
import it.quizzy.logiclayer.manager.DocenteManager;
import it.quizzy.logiclayer.manager.PartitaManager;
import it.quizzy.logiclayer.manager.UtenteManager;

class UtenteManagerTest {

	@Test
	void test() {
		
		DocenteManager dm = new DocenteManager();
		dm.signUp("Docente Test", "email@UMTest.it", "Password");
		Quiz q;
		try {
			q = new Quiz(dm.getId(), "Quiz di test");
			PartitaManager pm = new PartitaManager(new Docente("email@UMTest.it").getRecord().getId(), q.getRecord().getId());
			UtenteManager um = new UtenteManager("Utente Test", pm.getPin(), 0);
			pm.aggiungiGiocatore(um.getSessioneUtente());

			assertEquals(um.getNickname(), pm.getGiocatori().get(0).getRecord().getNickname());
			assertEquals(um.getPunteggio(), pm.getGiocatori().get(0).getRecord().getPunteggio());
			assertEquals(um.getPartitaPort(), pm.getServer().getPort());
			
			
			
		} catch (InvalidRecordInsertionException | RecordNotFoundException e) {
			e.printStackTrace();
		}
		

	}
}
