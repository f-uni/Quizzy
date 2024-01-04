package it.quizzy.databaselayer.models.domande;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import org.jooq.*;
import org.jooq.impl.DSL;

import it.quizzy.databaselayer.exceptions.InvalidRecordInsertionException;
import it.quizzy.databaselayer.exceptions.RecordNotFoundException;
import it.quizzy.databaselayer.models.Domanda;
import it.quizzy.databaselayer.util.DBConnection;
import it.quizzy.generated.tables.Domande;
import it.quizzy.generated.tables.records.DomandeRecord;

public class DomandaRispostaMultipla extends Domanda {

	private String domanda;
	private String rispostaCorretta;
	private List<String> possibiliRisposte;

	/**
	 * Costruttore per la ricerca e lettera di un domanda già esistente
	 * 
	 * @param id domanda
	 * @throws RecordNotFoundException
	 */
	public DomandaRispostaMultipla(Integer id) throws RecordNotFoundException {
		DSLContext create = DBConnection.getConnection();
		this.record = create.fetchOne(Domande.DOMANDE, Domande.DOMANDE.ID.eq(id));
		if (this.record == null)
			throw new RecordNotFoundException();
	}

	/**
	 * Costruttore per l'inserimento di una domanda di tipo risposta multipla
	 * 
	 * @param idQuiz           quiz in cui inserire la domanda
	 * @param domanda          stringa con il quesito
	 * @param rispostaCorretta
	 * @param possibiliRisposte
	 * @throws InvalidRecordInsertionException
	 * @throws IOException
	 */
	public DomandaRispostaMultipla(Integer idQuiz, String domanda, String rispostaCorretta,
			List<String> possibiliRisposte) throws InvalidRecordInsertionException, IOException {

		this.domanda = domanda;
		this.rispostaCorretta = rispostaCorretta;
		this.possibiliRisposte = possibiliRisposte;

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
		oos.flush();
		byte[] data = bos.toByteArray();

		DSLContext create = DBConnection.getConnection();

		Record1<Integer> res = create.select(DSL.max(Domande.DOMANDE.NUMERO_DOMANDA)).from(Domande.DOMANDE)
				.where(Domande.DOMANDE.ID_QUIZ.eq(idQuiz)).fetchOne();

		int numeroDomanda = 1;
		if (res != null) {
			numeroDomanda = res.get(0, int.class) + 1;
		}

		this.record = new DomandeRecord(null, idQuiz, numeroDomanda, TipoDomanda.RispostaMultipla.ordinal(), data);

		int result = create.insertInto(Domande.DOMANDE).set(this.record).execute();
		if (result != 1)
			throw new InvalidRecordInsertionException();
	}

	@Override
	public String getDomanda() {
		return domanda;
	}

	@Override
	public List<String> getRisposteDisponibili() {
		return possibiliRisposte;
	}

	@Override
	public boolean controllaRisposta(String risp) {
		return risp.equals(rispostaCorretta);
	}

}
