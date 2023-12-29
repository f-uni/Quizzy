package it.quizzy.databaselayer.exceptions;

public class InvalidRecordInsertionException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InvalidRecordInsertionException() {
		super("Non è stato possibile inserire il nuovo record");
	}
}
