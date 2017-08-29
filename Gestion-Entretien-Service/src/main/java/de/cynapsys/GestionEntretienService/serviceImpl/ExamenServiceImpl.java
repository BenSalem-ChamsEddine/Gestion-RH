package de.cynapsys.GestionEntretienService.serviceImpl;

import de.cynapsys.GestionEntretienService.entities.Examen;
import de.cynapsys.GestionEntretienService.repositories.ExamenRepository;
import de.cynapsys.GestionEntretienService.services.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chams Eddine on 14/06/2017.
 */

@Service
public class ExamenServiceImpl implements ExamenService {

    @Autowired
    ExamenRepository examenRepository;
    @Override
    public Examen saveExamen(Examen c) {
        return examenRepository.save(c);
    }

    @Override
    public Examen updateExamen(Examen c) {
        return examenRepository.save(c);
    }

    @Override
    public List<Examen> listExamens() {
        return examenRepository.findAll();
    }

    @Override
    public void removeExamen(Examen c) {
        examenRepository.delete(c);
    }

    @Override
    public void removeExamenById(int id) {
        examenRepository.delete(id);
    }

    @Override
    public List<Examen> findByNiveau(String niveau) {
        return examenRepository.findByNiveau(niveau);
    }

    @Override
    public List<Examen> findByPole(String pole) {
        return examenRepository.findByPole(pole);
    }

    @Override
    public List<Examen> findByType(String type) {
        return examenRepository.findByType(type);
    }

    @Override
    public Examen findById(int id) {
        return examenRepository.findById(id);
    }
}
