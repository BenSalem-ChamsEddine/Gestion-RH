package de.cynapsys.GestionEntretienService.services;

import de.cynapsys.GestionEntretienService.entities.Examen;
import de.cynapsys.GestionEntretienService.entities.Question;
import de.cynapsys.GestionEntretienService.entities.Questionexamen;

import java.util.List;

public interface QuestionExamenService {

	Questionexamen saveQuestionexamen(Questionexamen c);
	Questionexamen updateQuestionexamen(Questionexamen c);
	List<Questionexamen> listQuestionexamens();
	void removeQuestionexamen(Questionexamen c);
	void removeQuestionexamenById(int id);
	List<Questionexamen> findByQuestion(Question q);
	List<Questionexamen> findByExamen(Examen e);
	Questionexamen findById(int id);
}
