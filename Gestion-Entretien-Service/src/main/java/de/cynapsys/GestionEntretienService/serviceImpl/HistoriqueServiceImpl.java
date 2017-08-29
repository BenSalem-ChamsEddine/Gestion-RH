package de.cynapsys.GestionEntretienService.serviceImpl;

import de.cynapsys.GestionEntretienService.entities.*;
import de.cynapsys.GestionEntretienService.repositories.HistoriqueRepository;
import de.cynapsys.GestionEntretienService.services.HistoriqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chams Eddine on 14/06/2017.
 */

@Service
public class HistoriqueServiceImpl implements HistoriqueService {

    @Autowired
    HistoriqueRepository historiqueRepository;

    @Override
    public Historique saveHistorique(Historique c) {
        return historiqueRepository.save(c);
    }

    @Override
    public Historique updateHistorique(Historique c) {
        return historiqueRepository.save(c);
    }

    @Override
    public List<Historique> listHistoriques() {
        return historiqueRepository.findAll();
    }

    @Override
    public void removeHistorique(Historique c) {
        historiqueRepository.delete(c);
    }

    @Override
    public void removeHistoriqueById(int id) {
        historiqueRepository.delete(id);
    }

    @Override
    public List<Historique> findByExamen(Examen e) {
        return historiqueRepository.findByExamen(e);
    }

    @Override
    public List<Historique> findByEntretien(Entretien e) {
        return historiqueRepository.findByEntretien(e);
    }

    @Override
    public List<Historique> findByCandidat(Candidat c) {
        return historiqueRepository.findByCandidat(c);
    }

    @Override
    public List<Historique> findByReponses(String reponses) {
        return historiqueRepository.findByReponses(reponses);
    }

    @Override
    public List<Historique> findByQuestion(Question q) {
        return historiqueRepository.findByQuestion(q);
    }

    @Override
    public Historique findById(int id) {
        return historiqueRepository.findById(id);
    }
}
