package it.quizzy.databaselayer.models.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.quizzy.databaselayer.models.Docente;

class DocenteTest {

	@Test
	void create() {
		try {
			Docente d = new Docente("Docente Test", "test@test.it", "password");
			Integer id= d.getRecord().getId();
			Docente df=new Docente(id);
			assertEquals(d.getRecord().getEmail(), df.getRecord().getEmail());
			d.getRecord().delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
