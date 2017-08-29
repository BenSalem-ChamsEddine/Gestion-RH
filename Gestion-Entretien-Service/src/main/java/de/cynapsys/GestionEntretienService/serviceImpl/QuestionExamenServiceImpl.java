package de.cynapsys.GestionEntretienService.serviceImpl;

import de.cynapsys.GestionEntretienService.entities.Examen;
import de.cynapsys.GestionEntretienService.entities.Question;
import de.cynapsys.GestionEntretienService.entities.Questionexamen;
import de.cynapsys.GestionEntretienService.repositories.QuestionExamenRepository;
import de.cynapsys.GestionEntretienService.services.QuestionExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chams Eddine on 14/06/2017.
 */

@Service
public class QuestionExamenServiceImpl implements QuestionExamenService {

    @Autowired
    QuestionExamenRepository questionExamenRepository;

    @Override
    public Questionexamen saveQuestionexamen(Questionexamen c) {
        return questionExamenRepository.save(c);
    }

    @Override
    public Questionexamen updateQuestionexamen(Questionexamen c) {
        return questionExamenRepository.save(c);
    }

    @Override
    public List<Questionexamen> listQuestionexamens() {
        return questionExamenRepository.findAll();
    }

    @Override
    public void removeQuestionexamen(Questionexamen c) {
        questionExamenRepository.delete(c);
    }

    @Override
    public void removeQuestionexamenById(int id) {
        questionExamenRepository.delete(id);
    }

    @Override
    public List<Questionexamen> findByQuestion(Question q) {
        return questionExamenRepository.findByQuestion(q);
    }

    @Override
    public List<Questionexamen> findByExamen(Examen e) {
        return questionExamenRepository.findByExamen(e);
    }

    @Override
    public Questionexamen findById(int id) {
        return questionExamenRepository.findById(id);
    }
}
