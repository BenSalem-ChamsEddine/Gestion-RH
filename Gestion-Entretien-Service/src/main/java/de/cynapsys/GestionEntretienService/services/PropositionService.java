package de.cynapsys.GestionEntretienService.services;

import de.cynapsys.GestionEntretienService.entities.Proposition;
import de.cynapsys.GestionEntretienService.entities.Question;

import java.util.List;

public interface PropositionService {

	Proposition saveProposition(Proposition c);
	Proposition updateProposition(Proposition c);
	List<Proposition> listPropositions();
	void removeProposition(Proposition c);
	void removePropositionById(int id);
	List<Proposition> findByValiditee(boolean validitee);
	List<Proposition> findByEnonce(String enonce);
	List<Proposition> findByQuestion(Question q);
	Proposition findById(int id);
}
