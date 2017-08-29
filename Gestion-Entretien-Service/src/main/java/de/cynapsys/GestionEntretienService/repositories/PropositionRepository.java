package de.cynapsys.GestionEntretienService.repositories;

import de.cynapsys.GestionEntretienService.entities.Proposition;
import de.cynapsys.GestionEntretienService.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PropositionRepository extends JpaRepository<Proposition, Integer> {

	List<Proposition> findByValiditee(boolean validitee);
	List<Proposition> findByEnonce(String enonce);
	List<Proposition> findByQuestion(Question q);
	Proposition findById(int id);
	
}
