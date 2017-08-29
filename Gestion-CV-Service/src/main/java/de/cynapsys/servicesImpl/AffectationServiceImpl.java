package de.cynapsys.servicesImpl;

import de.cynapsys.entities.Affectation;
import de.cynapsys.entities.Candidat;
import de.cynapsys.repositories.AffectationRepository;
import de.cynapsys.services.AffectationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AffectationServiceImpl implements AffectationService {

    @Autowired
    AffectationRepository affectationRepository;

    @Override
    public Affectation saveAffectation(Affectation c) {
        return affectationRepository.save(c);
    }

    @Override
    public Affectation updateAffectation(Affectation c) {
        return affectationRepository.save(c);
    }

    @Override
    public List<Affectation> listAffectations() {
        return affectationRepository.findAll();
    }

    @Override
    public void removeAffectation(Affectation c) {
        affectationRepository.delete(c);
    }

    @Override
    public void removeAffectationById(int id) {
        affectationRepository.delete(id);
    }

    @Override
    public List<Affectation> findByCommercial(String commercial) {
        return affectationRepository.findByCommercial(commercial);
    }

    @Override
    public List<Affectation> findByDatedebut(Date dateDebut) {
        return affectationRepository.findByDatedebut(dateDebut);
    }

    @Override
    public List<Affectation> findByDatefin(Date dateFin) {
        return affectationRepository.findByDatefin(dateFin);
    }

    @Override
    public Affectation findByCandidat(Candidat candidat) {
        return affectationRepository.findByCandidat(candidat);
    }

    @Override
    public Affectation findById(int id) {
        return affectationRepository.findById(id);
    }
}
