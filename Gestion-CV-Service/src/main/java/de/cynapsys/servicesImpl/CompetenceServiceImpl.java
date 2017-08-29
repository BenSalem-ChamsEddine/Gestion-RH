package de.cynapsys.servicesImpl;

import de.cynapsys.entities.Competence;
import de.cynapsys.entities.Technologie;
import de.cynapsys.repositories.CompetenceRepository;
import de.cynapsys.repositories.TechnologieRepository;
import de.cynapsys.services.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenceServiceImpl implements CompetenceService {

    @Autowired
    CompetenceRepository competenceRepository;
    @Autowired
    TechnologieRepository technologieRepository;

    @Override
    public Competence saveCompetence(Competence c) {
        Competence competence = competenceRepository.save(c);
        if (c.getTechnologies() != null)
        for (Technologie t :c.getTechnologies()) {
            t=technologieRepository.findById(t.getId());
            t.setCompetence(competence);
            technologieRepository.save(t);
        }
        return competence;
    }

    @Override
    public Competence updateCompetence(Competence c) {
        return competenceRepository.save(c);
    }

    @Override
    public List<Competence> listCompetences() {
        return competenceRepository.findAll();
    }

    @Override
    public void removeCompetence(Competence c) {
        competenceRepository.delete(c);
    }

    @Override
    public void removeCompetenceById(int id) {
        competenceRepository.delete(id);
    }

    @Override
    public Competence findByLibelle(String libelle) {
        return competenceRepository.findByLibelle(libelle);
    }

    @Override
    public Competence findById(int id) {
        return competenceRepository.findById(id);
    }
}
