package it.quizzy.databaselayer.models;

import java.util.List;


import it.quizzy.generated.tables.records.DomandeRecord;

/**
 * Classe astratta model per la creazione e gestione delle domande
 */
public abstract class Domanda {
	public DomandeRecord record;
	
	public abstract String getDomanda();
	public abstract List<String> getRisposteDisponibili();
	public abstract boolean controllaRisposta(String risp);
	
	@Override
	public String toString() {
		return record.toString();
	}
}
