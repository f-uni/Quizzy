package it.quizzy.logiclayer.factory;

import java.io.IOException;
import java.util.List;

import it.quizzy.databaselayer.exceptions.InvalidRecordInsertionException;
import it.quizzy.databaselayer.models.Domanda;
import it.quizzy.databaselayer.models.domande.DomandaRispostaMultipla;
import it.quizzy.databaselayer.models.domande.DomandaVeroFalso;
import it.quizzy.databaselayer.models.domande.TipoDomanda;

/**
 * Classe Factory per la creazione delle domande
 */
public class DomandeFactory { 
	
	/**
	 * Metodo per la creazione delle domande
	 * 
	 * @param type tipo di domanda
	 * @param idQuiz quiz che conterrà la domanda
	 * @param domanda stringa della domanda 
	 * @param rispostaCorretta stringa risposta corretta
	 * @param possibiliRisposte lista di possibili risposte, se di tipo VeroFalso il parametro viene ignorato
	 * @return Domanda creata
	 * @throws IllegalArgumentException
	 * @throws InvalidRecordInsertionException
	 * @throws IOException
	 */
	public static Domanda createDomanda(TipoDomanda type, Integer idQuiz, String domanda, String rispostaCorretta, List<String> possibiliRisposte ) throws IllegalArgumentException, InvalidRecordInsertionException, IOException {
		Domanda obj = null;
        switch (type){
            case VeroFalso:
                obj = new DomandaVeroFalso(idQuiz, domanda, rispostaCorretta);
                break;
            case RispostaMultipla:
                obj = new DomandaRispostaMultipla(idQuiz, domanda, rispostaCorretta, possibiliRisposte);
                break;
        }
        return obj;
	}
	
}
