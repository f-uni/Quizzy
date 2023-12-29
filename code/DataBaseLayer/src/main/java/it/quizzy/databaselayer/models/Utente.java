package it.quizzy.databaselayer.models;

import org.jooq.DSLContext;

import it.quizzy.databaselayer.exceptions.InvalidRecordInsertionException;
import it.quizzy.databaselayer.exceptions.RecordNotFoundException;
import it.quizzy.databaselayer.util.DBConnection;
import it.quizzy.generated.tables.Utenti;
import it.quizzy.generated.tables.records.UtentiRecord;

/**
 * Classe model per la creazione e gestione degli utenti
 */
public class Utente {
	public UtentiRecord record;
	
	/**
	 * Costruttore per la ricerca e lettura di un utente già esistente
	 * 
	 * @param id utente da cercare
	 * @throws RecordNotFoundException
	 */
	public Utente(Integer id) throws RecordNotFoundException {
		DSLContext create = DBConnection.getConnection();
		this.record = create.fetchOne(Utenti.UTENTI, Utenti.UTENTI.ID.eq(id));
		if(this.record == null)
			throw new RecordNotFoundException();
	}
	
	public Utente(String nickname, Integer punteggio, Integer idPartita) throws InvalidRecordInsertionException {
		this.record = new UtentiRecord(null, nickname, punteggio, idPartita);
		DSLContext create = DBConnection.getConnection();
    	int result = create.insertInto(Utenti.UTENTI).set(this.record).execute();
    	if(result!=1)
    		throw new InvalidRecordInsertionException();
	}
}
