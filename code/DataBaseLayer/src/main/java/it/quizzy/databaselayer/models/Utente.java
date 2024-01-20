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
	private UtentiRecord record;

	/**
	 * Costruttore per la ricerca e lettura di un utente già esistente
	 * 
	 * @param id utente da cercare
	 * @throws RecordNotFoundException
	 */
	public Utente(Integer id) throws RecordNotFoundException {
		DSLContext create = DBConnection.getConnection();
		this.record = create.fetchOne(Utenti.UTENTI, Utenti.UTENTI.ID.eq(id));
		if (this.record == null)
			throw new RecordNotFoundException();
	}

	/**
	 * Costruttore per l'inserimento di un nuovo utente
	 * 
	 * @param nickname
	 * @param punteggio
	 * @param idPartita
	 * @throws InvalidRecordInsertionException
	 */
	public Utente(String nickname, Integer punteggio, Integer idPartita, Integer avatar) throws InvalidRecordInsertionException {
		this.record = new UtentiRecord(null, nickname, punteggio, idPartita, avatar);
		DSLContext create = DBConnection.getConnection();

		this.record = create.newRecord(Utenti.UTENTI);
		this.record.setNickname(nickname);
		this.record.setPunteggio(punteggio);
		this.record.setIdPartita(idPartita);
		this.record.setAvatar(avatar);

		int result = this.record.store();
		if (result != 1)
			throw new InvalidRecordInsertionException();
	}
	
	
	public void aggiungiPunti(int punti) {
		this.record.setPunteggio(this.record.getPunteggio()+punti);
		this.record.store();
	}
	
	@Override
	public String toString() {
		return record.toString();
	}

	public UtentiRecord getRecord() {
		return record;
	}
	
	
}
