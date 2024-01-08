package it.quizzy.databaselayer.models;

import java.util.ArrayList;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record2;
import org.jooq.Result;

import it.quizzy.databaselayer.exceptions.InvalidRecordInsertionException;
import it.quizzy.databaselayer.exceptions.RecordNotFoundException;
import it.quizzy.databaselayer.models.domande.DomandaRispostaMultipla;
import it.quizzy.databaselayer.models.domande.DomandaVeroFalso;
import it.quizzy.databaselayer.util.DBConnection;
import it.quizzy.generated.tables.Domande;
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
		if (this.record == null)
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

		DSLContext create = DBConnection.getConnection();

		this.record = create.newRecord(Quizzies.QUIZZIES);
		this.record.setIdDocente(idDocente);
		this.record.setTitolo(titolo);

		int result = this.record.store();

		if (result != 1)
			throw new InvalidRecordInsertionException();
	}

	/**
	 * Ritorna la lista di domande che compongono il quiz
	 * 
	 * @return
	 */
	public List<Domanda> getDomande() {
		DSLContext create = DBConnection.getConnection();

		Result<Record2<Integer, Integer>> res = create.select(Domande.DOMANDE.ID, Domande.DOMANDE.TIPO)
				.from(Domande.DOMANDE).where(Domande.DOMANDE.ID_QUIZ.eq(this.record.getId())).orderBy(Domande.DOMANDE.NUMERO_DOMANDA).fetch();

		List<Domanda> result = new ArrayList<>();
		for (Record2<Integer, Integer> r : res) {
			try {
				switch (r.get(1, int.class)) {
					case 0:
						result.add(new DomandaVeroFalso(r.get(0, int.class)));
						break;
					case 1:
						result.add(new DomandaRispostaMultipla(r.get(0, int.class)));
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + r.get(0, int.class));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;

	}

	@Override
	public String toString() {
		return record.toString();
	}
}
