package de.cynapsys.GestionEntretienService.services;

import de.cynapsys.GestionEntretienService.entities.Question;

import java.util.List;

public interface QuestionService {

	Question saveQuestion(Question c);
	Question saveQCMQuestion(Question c);
	Question updateQuestion(Question c);
	List<Question> listQuestions();
	void removeQuestion(Question c);
	void removeQuestionById(int id);
	List<Question> findByNiveau(String niveau);
	List<Question> findByType(String type);
	Question findById(int id);
}
