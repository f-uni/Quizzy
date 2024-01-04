package it.quizzy.databaselayer.models.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.ZoneOffset;

import org.junit.jupiter.api.Test;

import it.quizzy.databaselayer.models.Docente;
import it.quizzy.databaselayer.models.Partita;
import it.quizzy.databaselayer.models.Quiz;

class PartitaTest {

	@Test
	void create() {

		try {
			Docente d = new Docente("Docente Test", "test@test.it", "password");
			Quiz q = new Quiz(d.record.getId(), "Quiz di test");
			Partita p = new Partita(d.record.getId(), q.record.getId());
			Partita pf=new Partita(p.record.getId());
			assertEquals(p.record.getTimestamp().toEpochSecond(ZoneOffset.UTC), pf.record.getTimestamp().toEpochSecond(ZoneOffset.UTC));
			
			p.record.delete();
			q.record.delete();
			d.record.delete();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
