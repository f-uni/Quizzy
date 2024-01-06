package it.quizzy.databaselayer.models;

import java.util.ArrayList;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.exception.DataTypeException;
import org.jooq.impl.DSL;

import it.quizzy.databaselayer.exceptions.InvalidRecordInsertionException;
import it.quizzy.databaselayer.exceptions.RecordNotFoundException;
import it.quizzy.databaselayer.util.DBConnection;
import it.quizzy.databaselayer.util.StringHash;
import it.quizzy.generated.tables.Docenti;
import it.quizzy.generated.tables.Domande;
import it.quizzy.generated.tables.Quizzies;
import it.quizzy.generated.tables.records.DocentiRecord;
import it.quizzy.generated.tables.records.QuizziesRecord;

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

	/**
	 * Metodo per ottenere tutti i quiz del docente
	 * 
	 * @return lista di Quiz
	 */
	public List<Quiz> getQuizzies() {
		DSLContext create = DBConnection.getConnection();

		Result<Record1<Integer>> res = create.select(Quizzies.QUIZZIES.ID).from(Quizzies.QUIZZIES)
				.where(Quizzies.QUIZZIES.ID_DOCENTE.eq(this.record.getId())).fetch();

		List<Quiz> result = new ArrayList<>();
		for (Record1<Integer> r : res) {
			try {
				result.add(new Quiz(r.get(0, int.class)));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	/**
	 * Metodo per la creazione di un quiz da parte del docente
	 * 
	 * @param titolo nome del quiz
	 * @return ripsettivamente true o false se la creazione ha avuto successo o no
	 */
	public boolean creaQuiz(String titolo) {
		try {
			new Quiz(this.record.getId(), titolo);
			return true;
		} catch (InvalidRecordInsertionException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String toString() {
		return record.toString();
	}

}
