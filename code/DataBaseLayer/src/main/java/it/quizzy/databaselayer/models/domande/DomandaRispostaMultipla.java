package it.quizzy.databaselayer.models.domande;

import java.io.IOException;

import java.util.List;

import org.apache.commons.lang3.SerializationUtils;
import org.jooq.*;
import org.jooq.impl.DSL;

import it.quizzy.databaselayer.exceptions.InvalidRecordInsertionException;
import it.quizzy.databaselayer.exceptions.RecordNotFoundException;
import it.quizzy.databaselayer.models.Domanda;
import it.quizzy.databaselayer.util.DBConnection;
import it.quizzy.generated.tables.Domande;

/**
 * Domanda di tipo risposta multipla
 */
public class DomandaRispostaMultipla extends Domanda {

	private static final long serialVersionUID = 1L;
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
		
		DomandaRispostaMultipla obj = SerializationUtils.deserialize(this.record.getObj());
		
		this.domanda=obj.domanda;
		this.rispostaCorretta=obj.rispostaCorretta;
		this.possibiliRisposte=obj.possibiliRisposte;
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

		byte[] data = SerializationUtils.serialize(this);

		DSLContext create = DBConnection.getConnection();

		Record1<Integer> res = create.select(DSL.max(Domande.DOMANDE.NUMERO_DOMANDA)).from(Domande.DOMANDE)
				.where(Domande.DOMANDE.ID_QUIZ.eq(idQuiz)).fetchOne();

		int numeroDomanda = 1;
		if (res != null) {
			numeroDomanda = res.get(0, int.class) + 1;
		}

		this.record=create.newRecord(Domande.DOMANDE);
		this.record.setIdQuiz(idQuiz);
		this.record.setNumeroDomanda(numeroDomanda);
		this.record.setTipo(TipoDomanda.RispostaMultipla.ordinal());
		this.record.setObj(data);
		
		int result = this.record.store();
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
