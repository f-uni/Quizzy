package it.quizzy.databaselayer.models;

import org.jooq.DSLContext;

import it.quizzy.databaselayer.exceptions.RecordNotFoundException;
import it.quizzy.databaselayer.util.DBConnection;
import it.quizzy.generated.tables.Domande;
import it.quizzy.generated.tables.records.DomandeRecord;

/**
 * Classe model per la creazione e gestione delle domande
 */
public class Domanda {
	public DomandeRecord record;
	
	/**
	 * Costruttore per la ricerca e lettera di un domanda già esistente
	 * 
	 * @param id domanda
	 * @throws RecordNotFoundException
	 */
	public Domanda(Integer id) throws RecordNotFoundException {
		DSLContext create = DBConnection.getConnection();
		this.record = create.fetchOne(Domande.DOMANDE, Domande.DOMANDE.ID.eq(id));
		if(this.record == null)
			throw new RecordNotFoundException();
	}

	//TODO: scrivere documentazione
	public Domanda (Integer idQuiz, Integer numeroDomanda, Integer tipo) {
		//TODO: implementare le domande
	}
	
}
