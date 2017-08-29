package de.cynapsys.GestionEntretienService.serviceImpl;

import de.cynapsys.GestionEntretienService.entities.Proposition;
import de.cynapsys.GestionEntretienService.entities.Question;
import de.cynapsys.GestionEntretienService.repositories.QuestionRepository;
import de.cynapsys.GestionEntretienService.services.PropositionService;
import de.cynapsys.GestionEntretienService.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chams Eddine on 14/06/2017.
 */

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    PropositionService propositionService;

    @Override
    public Question saveQuestion(Question c) {
        return questionRepository.save(c);
    }
    @Override
    public Question saveQCMQuestion(Question c) {
        Question question = questionRepository.save(c);
        for (Proposition p :
                c.getPropositions()) {
            p.setQuestion(c);
            propositionService.saveProposition(p);
        }
        return question;
    }

    @Override
    public Question updateQuestion(Question c) {
        return questionRepository.save(c);
    }

    @Override
    public List<Question> listQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public void removeQuestion(Question c) {
        questionRepository.delete(c);
    }

    @Override
    public void removeQuestionById(int id) {
        questionRepository.delete(id);
    }

    @Override
    public List<Question> findByNiveau(String niveau) {
        return questionRepository.findByNiveau(niveau);
    }

    @Override
    public List<Question> findByType(String type) {
        return questionRepository.findByType(type);
    }

    @Override
    public Question findById(int id) {
        return questionRepository.findById(id);
    }
}
