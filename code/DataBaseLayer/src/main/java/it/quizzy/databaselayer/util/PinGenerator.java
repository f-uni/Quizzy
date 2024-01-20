package it.quizzy.databaselayer.util;

import java.util.Random;

public class PinGenerator {
	public static String newPin() {
		Random rnd = new Random();
	    int number = rnd.nextInt(999999);

	    return String.format("%06d", number);
	}
}
