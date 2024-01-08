package it.quizzy.databaselayer.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe util per la gestione dell' hashing di stringhe
 */
public class StringHash {
	
	/**
	 * Hash SHA-256 di una stringa
	 * @param str stringa 
	 * @return hash SHA-256 di str
	 */
	public static String hash(String str) {
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(str.getBytes());
			return new String(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
