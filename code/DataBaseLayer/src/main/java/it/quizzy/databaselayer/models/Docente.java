package it.quizzy.databaselayer.models;

import org.jooq.DSLContext;

import it.quizzy.databaselayer.exceptions.InvalidRecordInsertionException;
import it.quizzy.databaselayer.exceptions.RecordNotFoundException;
import it.quizzy.databaselayer.util.DBConnection;
import it.quizzy.databaselayer.util.StringHash;
import it.quizzy.generated.tables.Docenti;
import it.quizzy.generated.tables.records.DocentiRecord;

/**
 * Classe model per la creazione e gestione dei docenti
 */
public class Docente {
	public DocentiRecord record;

	/**
	 * Costruttore per la ricerca e lettura di un docente già esistente
	 * 
	 * @param id docente da cercare
	 * @throws RecordNotFoundException
	 */
	public Docente(Integer id) throws RecordNotFoundException {
		DSLContext create = DBConnection.getConnection();
		this.record = create.fetchOne(Docenti.DOCENTI, Docenti.DOCENTI.ID.eq(id));
		if (this.record == null)
			throw new RecordNotFoundException();
	}

	/**
	 * Costruttore per la ricerca e lettura di un docente già esistente
	 * 
	 * @param email docente da cercare
	 * @throws RecordNotFoundException
	 */
	public Docente(String email) throws RecordNotFoundException {
		DSLContext create = DBConnection.getConnection();
		this.record = create.fetchOne(Docenti.DOCENTI, Docenti.DOCENTI.EMAIL.eq(email));
		if (this.record == null)
			throw new RecordNotFoundException();
	}

	/**
	 * Costruttore per l'inserimento di un nuovo docente
	 * 
	 * @param nomeCompleto
	 * @param email
	 * @param passwordHash
	 * @throws InvalidRecordInsertionException
	 */
	public Docente(String nomeCompleto, String email, String password) throws InvalidRecordInsertionException {
		String passwordHash = StringHash.hash(password);
		DSLContext create = DBConnection.getConnection();

		this.record = create.newRecord(Docenti.DOCENTI);
		this.record.setNomeCompleto(nomeCompleto);
		this.record.setEmail(email);
		this.record.setPasswordHash(passwordHash);

		int result = this.record.store();

		if (result != 1)
			throw new InvalidRecordInsertionException();

	}
	
	@Override
	public String toString() {
		return record.toString();
	}

}
