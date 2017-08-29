package de.cynapsys.GestionEntretienService.repositories;

import de.cynapsys.GestionEntretienService.entities.Examen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamenRepository extends JpaRepository<Examen, Integer> {

	List<Examen> findByNiveau(String niveau);
	List<Examen> findByPole(String pole);
	List<Examen> findByType(String type);
	Examen findById(int id);
}
