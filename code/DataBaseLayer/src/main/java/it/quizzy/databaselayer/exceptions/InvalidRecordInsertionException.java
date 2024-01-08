package it.quizzy.databaselayer.exceptions;

/**
 * Eccezione invocata quando l'insert o l'update di un record non ha esito positivo
 */
public class InvalidRecordInsertionException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InvalidRecordInsertionException() {
		super("Non è stato possibile inserire il nuovo record");
	}
}
