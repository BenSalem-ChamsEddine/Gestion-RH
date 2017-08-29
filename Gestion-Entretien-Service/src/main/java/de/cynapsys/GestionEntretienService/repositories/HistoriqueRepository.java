package de.cynapsys.GestionEntretienService.repositories;

import de.cynapsys.GestionEntretienService.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoriqueRepository extends JpaRepository<Historique, Integer> {

	List<Historique> findByExamen(Examen e);
	List<Historique> findByEntretien(Entretien e);
	List<Historique> findByCandidat(Candidat c);
	List<Historique> findByReponses(String reponses);
	List<Historique> findByQuestion(Question q);
	Historique findById(int id);
}
