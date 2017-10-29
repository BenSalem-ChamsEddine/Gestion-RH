package de.cynapsys.GestionEntretienService.serviceImpl;

import de.cynapsys.GestionEntretienService.entities.Entretien;
import de.cynapsys.GestionEntretienService.entities.Entretienexamen;
import de.cynapsys.GestionEntretienService.entities.Examen;
import de.cynapsys.GestionEntretienService.repositories.EntretienExamenRepository;
import de.cynapsys.GestionEntretienService.services.EntretienExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chams Eddine on 14/06/2017.
 */

@Service
public class EntretienExamenServiceImpl implements EntretienExamenService {

    @Autowired
    private EntretienExamenRepository entretienExamenRepository;

    @Override
    public Entretienexamen saveEntretienexamen(Entretienexamen c) {
        return entretienExamenRepository.save(c);
    }

    @Override
    public Entretienexamen updateEntretienexamen(Entretienexamen c) {
        return entretienExamenRepository.save(c);
    }

    @Override
    public List<Entretienexamen> listEntretienexamens() {
        return entretienExamenRepository.findAll();
    }

    @Override
    public void removeEntretienexamen(Entretienexamen c) {
        entretienExamenRepository.delete(c);
    }

    @Override
    public void removeEntretienexamenById(int id) {
        entretienExamenRepository.delete(id);
    }

    @Override
    public List<Entretienexamen> findByEntretien(int id) {
        Entretien e = new Entretien();
        e.setId(id);
        return entretienExamenRepository.findByEntretien(e);
    }

    @Override
    public List<Entretienexamen> findByExamen(Examen e) {
        return entretienExamenRepository.findByExamen(e);
    }

    @Override
    public Entretienexamen findById(int id) {
        return entretienExamenRepository.findById(id);
    }
}
