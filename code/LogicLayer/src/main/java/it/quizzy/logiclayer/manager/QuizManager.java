package it.quizzy.logiclayer.manager;

import java.util.List;

import it.quizzy.databaselayer.models.Domanda;
import it.quizzy.databaselayer.models.Quiz;
import it.quizzy.databaselayer.models.domande.DomandaRispostaMultipla;
import it.quizzy.databaselayer.models.domande.DomandaVeroFalso;

/**
 * Gestisce le modifiche da parte del docente sui quiz 
 */
public class QuizManager {
	Quiz quiz;

	/** 
	 * Costruttore per la creazione di un quiz manager
	 * @param quiz
	 */
	public QuizManager(Quiz quiz) {
		this.quiz = quiz;
	}

	/**
	 * Gestisce l'aggiunta di una nuova domanda vero o falso ad un quiz già esistente
	 * 
	 * @param domanda
	 * @param rispostaCorretta
	 * @return
	 */
	public boolean aggiungiDomandaVeroFalso(String domanda, String rispostaCorretta) {
		try {
			new DomandaVeroFalso(quiz.getRecord().getId(), domanda, rispostaCorretta);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Gestisce l'aggiunta di una nuova domanda a risposta multipla ad un quiz già esistente
	 * 
	 * @param domanda
	 * @param rispostaCorretta
	 * @param possibiliRisposte
	 * @return
	 */
	public boolean aggiungiDomandaRispostaMultipla(String domanda, String rispostaCorretta, List<String> possibiliRisposte) {
		try {
			new DomandaRispostaMultipla(quiz.getRecord().getId(), domanda, rispostaCorretta, possibiliRisposte);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Rimuove una domanda esistente da un quiz già esistente
	 * 
	 * @param idDomanda
	 * @return
	 */
	public boolean rimuoviDomanda(Integer idDomanda) {
		List<Domanda> domande = quiz.getDomande();
		Domanda domandaDaEliminare = null;
		for(Domanda d : domande) {
			if(d.getRecord().getId().equals(idDomanda)) {
				domandaDaEliminare=d;
				break;
			}
		}
		
		if(domandaDaEliminare==null)
			return false;
		
		for(Domanda d:domande) {
			if(d.getRecord().getNumeroDomanda()>domandaDaEliminare.getRecord().getNumeroDomanda()) {
				d.getRecord().setNumeroDomanda(d.getRecord().getNumeroDomanda()-1);
				d.getRecord().store();
			}
		}
		
		return domandaDaEliminare.getRecord().delete()==1;
		
	}
	
}
