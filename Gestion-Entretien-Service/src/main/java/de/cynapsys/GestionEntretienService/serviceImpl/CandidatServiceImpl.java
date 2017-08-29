package de.cynapsys.GestionEntretienService.serviceImpl;

import de.cynapsys.GestionEntretienService.entities.Candidat;
import de.cynapsys.GestionEntretienService.repositories.CandidatRepository;
import de.cynapsys.GestionEntretienService.services.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Chams Eddine on 14/06/2017.
 */

@Service
@Transactional
public class CandidatServiceImpl implements CandidatService {

    @Autowired
    CandidatRepository candidatRepository;

    @Override
    public Candidat saveCandidat(Candidat c) {
        return candidatRepository.save(c);
    }

    @Override
    public Candidat updateCandidat(Candidat c) {
        return candidatRepository.save(c);
    }

    @Override
    public List<Candidat> listCandidats() {
        return candidatRepository.findAll();
    }

    @Override
    public void removeCandidat(Candidat c) {
        candidatRepository.delete(c);
    }

    @Override
    public void removeCandidatById(int id) {
        candidatRepository.delete(id);
    }

    @Override
    public List<Candidat> findByCompetences(String competences) {
        return candidatRepository.findByCompetences(competences);
    }

    @Override
    public Candidat findByCin(long cin) {
        return candidatRepository.findByCin(cin);
    }

    @Override
    public Candidat findByEmail(String email) {
        return candidatRepository.findByEmail(email);
    }

    @Override
    public Candidat findById(int id) {
        return candidatRepository.findById(id);
    }
}
