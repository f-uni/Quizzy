package it.quizzy.logiclayer.test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.quizzy.logiclayer.manager.DocenteManager;

class DocenteManagerTest {

	@Test
	void login() {
		DocenteManager lm = new DocenteManager();
		lm.login("test@test.it", "password");
		assertTrue(lm.isLogged());
	}

	@Test
	void failedLogin() {
		DocenteManager lm = new DocenteManager();
		lm.login("test@test.it", "passwordsbagliata");
		assertFalse(lm.isLogged());
	}
}
