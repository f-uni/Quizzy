package it.quizzy.databaselayer.models;

import org.jooq.DSLContext;

import it.quizzy.databaselayer.exceptions.InvalidRecordInsertionException;
import it.quizzy.databaselayer.exceptions.RecordNotFoundException;
import it.quizzy.databaselayer.util.DBConnection;
import it.quizzy.generated.tables.Quizzies;
import it.quizzy.generated.tables.records.QuizziesRecord;

/**
 * Classe model per la creazione e gestione dei quiz
 */
public class Quiz {
	public QuizziesRecord record;
	
	/**
	 * Costruttore per la ricerca e la lettura di un quiz già esistente
	 * 
	 * @param id quiz da cercare
	 * @throws RecordNotFoundException
	 */
	public Quiz(Integer id) throws RecordNotFoundException {		
		DSLContext create = DBConnection.getConnection();
		this.record = create.fetchOne(Quizzies.QUIZZIES, Quizzies.QUIZZIES.ID.eq(id));
		if(this.record == null)
			throw new RecordNotFoundException();
	}

	/**
	 * Costruttore per l'inserimento di un nuovo quiz
	 * 
	 * @param idDocente
	 * @param titolo
	 * @throws InvalidRecordInsertionException
	 */
	public Quiz(Integer idDocente, String titolo) throws InvalidRecordInsertionException {
		this.record = new QuizziesRecord(null, idDocente, titolo);
		DSLContext create = DBConnection.getConnection();
		int result = create.insertInto(Quizzies.QUIZZIES).set(this.record).execute();
		if(result!=1)
    		throw new InvalidRecordInsertionException();
	}
}
