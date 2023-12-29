package it.quizzy.databaselayer.exceptions;

public class RecordNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public RecordNotFoundException() {
		super("Record non presente nel database");
	}

}
