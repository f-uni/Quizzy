package it.quizzy.databaselayer.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringHash {
	
	public static String hash(String str) {

		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(str.getBytes());
			return new String(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
