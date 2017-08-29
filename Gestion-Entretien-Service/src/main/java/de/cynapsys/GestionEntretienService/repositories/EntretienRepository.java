package de.cynapsys.GestionEntretienService.repositories;

import de.cynapsys.GestionEntretienService.entities.Candidat;
import de.cynapsys.GestionEntretienService.entities.Entretien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface EntretienRepository extends JpaRepository<Entretien, Integer> {
	
	List<Entretien> findByDate(Date d);
	List<Entretien> findByCandidat(Candidat c);
	Entretien findById(int id);
}
