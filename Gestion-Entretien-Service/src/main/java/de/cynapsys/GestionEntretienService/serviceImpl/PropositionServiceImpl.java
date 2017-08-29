package de.cynapsys.GestionEntretienService.serviceImpl;

import de.cynapsys.GestionEntretienService.entities.Proposition;
import de.cynapsys.GestionEntretienService.entities.Question;
import de.cynapsys.GestionEntretienService.repositories.PropositionRepository;
import de.cynapsys.GestionEntretienService.services.PropositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chams Eddine on 14/06/2017.
 */
@Service
public class PropositionServiceImpl implements PropositionService {

    @Autowired
    PropositionRepository propositionRepository;

    @Override
    public Proposition saveProposition(Proposition c) {
        return propositionRepository.save(c);
    }

    @Override
    public Proposition updateProposition(Proposition c) {
        return propositionRepository.save(c);
    }

    @Override
    public List<Proposition> listPropositions() {
        return propositionRepository.findAll();
    }

    @Override
    public void removeProposition(Proposition c) {
        propositionRepository.delete(c);
    }

    @Override
    public void removePropositionById(int id) {
        propositionRepository.delete(id);
    }

    @Override
    public List<Proposition> findByValiditee(boolean validitee) {
        return propositionRepository.findByValiditee(validitee);
    }

    @Override
    public List<Proposition> findByEnonce(String enonce) {
        return propositionRepository.findByEnonce(enonce);
    }

    @Override
    public List<Proposition> findByQuestion(Question q) {
        return propositionRepository.findByQuestion(q);
    }

    @Override
    public Proposition findById(int id) {
        return propositionRepository.findById(id);
    }
}
