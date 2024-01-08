package it.quizzy.databaselayer.models;

import java.time.LocalDateTime;

import org.jooq.DSLContext;

import it.quizzy.databaselayer.exceptions.InvalidRecordInsertionException;
import it.quizzy.databaselayer.exceptions.RecordNotFoundException;
import it.quizzy.databaselayer.util.DBConnection;
import it.quizzy.generated.tables.Partite;
import it.quizzy.generated.tables.records.PartiteRecord;

/**
 * Classe model per la creazione e gestione dei partita
 */
public class Partita {
	public PartiteRecord record;

	/**
	 * Costruttore per la ricerca e la lettura di una partita già esistente
	 * 
	 * @param id partita da cercare
	 * @throws RecordNotFoundException
	 */
	public Partita(Integer id) throws RecordNotFoundException {		
		DSLContext create = DBConnection.getConnection();
		this.record = create.fetchOne(Partite.PARTITE, Partite.PARTITE.ID.eq(id));
		if(this.record == null)
			throw new RecordNotFoundException();
	}

	/**
	 * Costruttore per l'inserimento di un nuovo partita
	 * 
	 * @param idDocente
	 * @param idQuiz
	 * @throws InvalidRecordInsertionException
	 */
	public Partita(Integer idDocente, Integer idQuiz) throws InvalidRecordInsertionException {
		LocalDateTime timestamp = LocalDateTime.now();
		
		DSLContext create = DBConnection.getConnection();
		
		this.record=create.newRecord(Partite.PARTITE);
		this.record.setTimestamp(timestamp);
		this.record.setIdDocente(idDocente);
		this.record.setIdQuiz(idQuiz);
		
		int result = this.record.store();
		if(result!=1)
    		throw new InvalidRecordInsertionException();
	}
	
	@Override
	public String toString() {
		return record.toString();
	}
}
