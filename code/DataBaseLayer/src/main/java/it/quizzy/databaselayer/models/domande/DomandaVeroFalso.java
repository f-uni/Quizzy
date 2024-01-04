package it.quizzy.databaselayer.models.domande;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jooq.*;
import org.jooq.impl.DSL;

import it.quizzy.databaselayer.exceptions.InvalidRecordInsertionException;
import it.quizzy.databaselayer.exceptions.RecordNotFoundException;
import it.quizzy.databaselayer.models.Domanda;
import it.quizzy.databaselayer.util.DBConnection;
import it.quizzy.generated.tables.Domande;
import it.quizzy.generated.tables.records.DomandeRecord;

enum Risposta {

	VERO("vero"), FALSO("falso");

	String value;

	Risposta(String str) {
		this.value = str;
	}

	public static Risposta fromStirng(String str) {
		switch (str.toLowerCase()) {
		case "vero":
			return Risposta.VERO;
		case "falso":
			return Risposta.FALSO;
		default:
			throw new IllegalArgumentException("Unexpected value: " + str);
		}
	}

	public String toString() {
		return value;
	}
}

public class DomandaVeroFalso extends Domanda {

	private String domanda;
	private Risposta rispostaCorretta;

	/**
	 * Costruttore per la ricerca e lettera di un domanda già esistente
	 * 
	 * @param id domanda
	 * @throws RecordNotFoundException
	 */
	public DomandaVeroFalso(Integer id) throws RecordNotFoundException {
		DSLContext create = DBConnection.getConnection();
		this.record = create.fetchOne(Domande.DOMANDE, Domande.DOMANDE.ID.eq(id));
		if (this.record == null)
			throw new RecordNotFoundException();
	}

	/**
	 * Costruttore per l'inserimento di una domanda di tipo vero o falso
	 * 
	 * @param idQuiz           quiz in cui inserire la domanda
	 * @param domanda          stringa con il quesito
	 * @param rispostaCorretta
	 * @throws InvalidRecordInsertionException
	 * @throws IOException
	 */
	public DomandaVeroFalso(Integer idQuiz, String domanda, Risposta rispostaCorretta)
			throws InvalidRecordInsertionException, IOException {

		this.domanda = domanda;
		this.rispostaCorretta = rispostaCorretta;

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

		this.record = new DomandeRecord(null, idQuiz, numeroDomanda, TipoDomanda.VeroFalso.ordinal(), data);

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
		return new ArrayList<String>(Arrays.asList(Risposta.VERO.toString(), Risposta.FALSO.toString()));
	}

	@Override
	public boolean controllaRisposta(String risp) {
		Risposta r = Risposta.fromStirng(risp);
		return r == rispostaCorretta;
	}

}
