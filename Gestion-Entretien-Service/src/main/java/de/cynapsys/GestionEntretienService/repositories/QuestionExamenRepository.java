package de.cynapsys.GestionEntretienService.repositories;

import de.cynapsys.GestionEntretienService.entities.Examen;
import de.cynapsys.GestionEntretienService.entities.Question;
import de.cynapsys.GestionEntretienService.entities.Questionexamen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionExamenRepository extends JpaRepository<Questionexamen, Integer> {

	List<Questionexamen> findByQuestion(Question q);
	List<Questionexamen> findByExamen(Examen e);
	Questionexamen findById(int id);
}
