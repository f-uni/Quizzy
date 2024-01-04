package it.quizzy.databaselayer.exceptions;

/**
 * Eccezione invocata quando fallisce il fetch di un record nel db
 */
public class RecordNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public RecordNotFoundException() {
		super("Record non presente nel database");
	}

}
