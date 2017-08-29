package de.cynapsys.GestionEntretienService.repositories;

import de.cynapsys.GestionEntretienService.entities.Entretien;
import de.cynapsys.GestionEntretienService.entities.Entretienexamen;
import de.cynapsys.GestionEntretienService.entities.Examen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntretienExamenRepository extends JpaRepository<Entretienexamen, Integer> {

	List<Entretienexamen> findByEntretien(Entretien e);
	List<Entretienexamen> findByExamen(Examen e);
	Entretienexamen findById(int id);
}
