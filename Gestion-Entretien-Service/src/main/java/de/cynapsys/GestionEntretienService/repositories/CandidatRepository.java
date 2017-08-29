package de.cynapsys.GestionEntretienService.repositories;

import de.cynapsys.GestionEntretienService.entities.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidatRepository extends JpaRepository<Candidat, Integer> {

	List<Candidat> findByCompetences(String competences);
	Candidat findByCin(long cin);
	Candidat findByEmail(String email);
	Candidat findById(int id);
}
