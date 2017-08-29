package de.cynapsys.servicesImpl;

import de.cynapsys.entities.Competence;
import de.cynapsys.entities.Technologie;
import de.cynapsys.repositories.TechnologieRepository;
import de.cynapsys.services.TechnologieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechnologieServiceImpl implements TechnologieService {

    @Autowired
    TechnologieRepository technologieRepository;

    @Override
    public Technologie saveTechnologie(Technologie c) {
        return technologieRepository.save(c);
    }

    @Override
    public Technologie updateTechnologie(Technologie c) {
        return technologieRepository.save(c);
    }

    @Override
    public List<Technologie> listTechnologies() {
        List<Technologie> technologieList = technologieRepository.findAll();
        if (technologieList == null)
            return new ArrayList<Technologie>();
        return technologieList;
    }

    @Override
    public void removeTechnologie(Technologie c) {
        technologieRepository.delete(c);
    }

    @Override
    public void removeTechnologieById(int id) {
        technologieRepository.delete(id);
    }

    @Override
    public Technologie findById(int id) {
        Technologie technologie = technologieRepository.findById(id);
        if(technologie == null){
            technologie = new Technologie();
            technologie.setCompetence(new Competence());
            return technologie;
        }
        return technologie;
    }

    @Override
    public List<Technologie> findByLibelle(String libelle) {
        return technologieRepository.findByLibelle(libelle);
    }

    @Override
    public List<Technologie> findByCompetence(Competence competence) {
        return technologieRepository.findByCompetence(competence);
    }
}
