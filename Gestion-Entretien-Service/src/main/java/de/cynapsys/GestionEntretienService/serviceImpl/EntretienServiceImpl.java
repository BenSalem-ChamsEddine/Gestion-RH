package de.cynapsys.GestionEntretienService.serviceImpl;

import de.cynapsys.GestionEntretienService.entities.Candidat;
import de.cynapsys.GestionEntretienService.entities.Entretien;
import de.cynapsys.GestionEntretienService.repositories.EntretienRepository;
import de.cynapsys.GestionEntretienService.services.EntretienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Chams Eddine on 14/06/2017.
 */

@Service
public class EntretienServiceImpl implements EntretienService {

    @Autowired
    EntretienRepository entretienRepository;

    @Override
    public Entretien saveEntretien(Entretien c) {
        return entretienRepository.save(c);
    }

    @Override
    public Entretien updateEntretien(Entretien c) {
        return entretienRepository.save(c);
    }

    @Override
    public List<Entretien> listEntretiens() {
        return entretienRepository.findAll();
    }

    @Override
    public void removeEntretien(Entretien c) {
        entretienRepository.delete(c);
    }

    @Override
    public void removeEntretienById(int id) {
        entretienRepository.delete(id);
    }

    @Override
    public List<Entretien> findByDate(Date d) {
        return entretienRepository.findByDate(d);
    }

    @Override
    public List<Entretien> findByCandidat(int id) {
        Candidat c = new Candidat();
        c.setId(id);
        return entretienRepository.findByCandidat(c);
    }

    @Override
    public Entretien findById(int id) {
        return entretienRepository.findById(id);
    }
}
