package it.quizzy.databaselayer.models;

import java.io.Serializable;
import java.util.List;

import it.quizzy.generated.tables.records.DomandeRecord;

/**
 * Classe astratta model per la creazione e gestione delle domande
 */
public abstract class Domanda implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	protected DomandeRecord record;

	/**
	 * @return la stringa contenente la domanda
	 */
	public abstract String getDomanda();

	/**
	 * @return lista di stringhe contenente le possibili risposte
	 */
	public abstract List<String> getRisposteDisponibili();

	/**
	 * @param risp risposta da controllare
	 * @return true o false se la risposta è rispettivamente corretta o errata
	 */
	public abstract boolean controllaRisposta(String risp);

	@Override
	public String toString() {
		return record.toString();
	}
	
	public DomandeRecord getRecord() {
		return record;
	}
	
}
