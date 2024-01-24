package it.quizzy.databaselayer.models.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.ZoneOffset;

import org.junit.jupiter.api.Test;

import it.quizzy.databaselayer.exceptions.InvalidRecordInsertionException;
import it.quizzy.databaselayer.models.Docente;
import it.quizzy.databaselayer.models.Partita;
import it.quizzy.databaselayer.models.Quiz;

class PartitaTest {

	@Test
	void create() {

		try {
			Docente d = new Docente("Docente Test", "test@test.it", "password");
			Quiz q = new Quiz(d.getRecord().getId(), "Quiz di test");
			Partita p = new Partita(d.getRecord().getId(), q.getRecord().getId());
			Partita pf = new Partita(p.getRecord().getId());
			assertEquals(p.getRecord().getTimestamp().toEpochSecond(ZoneOffset.UTC),
					pf.getRecord().getTimestamp().toEpochSecond(ZoneOffset.UTC));
			
			Partita p2 = new Partita(p.getRecord().getPin());
			
			assertEquals(pf.toString(), p2.toString());
			
			int port = 2323;
			p2.setSocketPort(port);
			assertEquals(port, p2.getRecord().getPort());

			p.getRecord().delete();
			p2.getRecord().delete();
			q.getRecord().delete();
			d.getRecord().delete();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	void connection() {

		Docente d;
		try {
			d = new Docente("Docente Test", "test@test.it", "password");
			Quiz q = new Quiz(d.getRecord().getId(), "Quiz di test");
			Partita p = new Partita(d.getRecord().getId(), q.getRecord().getId());
			
			
		} catch (InvalidRecordInsertionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
