package it.quizzy.logiclayer.test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.quizzy.logiclayer.LoginManager;

class LoginManagerTest {

	@Test
	void login() {
		LoginManager lm = new LoginManager();
		lm.login("test@test.it", "password");
		assertTrue(lm.isLogged());
	}

	@Test
	void failedLogin() {
		LoginManager lm = new LoginManager();
		lm.login("test@test.it", "passwordsbagliata");
		assertFalse(lm.isLogged());
	}
}
