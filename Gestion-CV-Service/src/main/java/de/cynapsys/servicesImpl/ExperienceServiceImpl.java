package de.cynapsys.servicesImpl;

import de.cynapsys.entities.Candidat;
import de.cynapsys.entities.Experience;
import de.cynapsys.entities.Projet;
import de.cynapsys.entities.Tache;
import de.cynapsys.repositories.ExperienceRepository;
import de.cynapsys.repositories.ProjetRepository;
import de.cynapsys.repositories.TacheRepository;
import de.cynapsys.services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ExperienceServiceImpl implements ExperienceService {

    @Autowired
    ExperienceRepository experienceRepository;
    @Autowired
    TacheRepository tacheRepository;
    @Autowired
    ProjetRepository projetRepository;

    @Override
    public Experience saveExperience(Experience c) {
        c.setProjet(projetRepository.findById(c.getProjet().getId()));
        List<Tache> tacheList = c.getTaches();
        c.setTaches(null);
        Experience experience = experienceRepository.save(c);
        for(Tache tache : tacheList){
            Tache t= tacheRepository.findById(tache.getId());
            t.setExperience(experience);
            tacheRepository.save(t);
            if (experience.getTaches() == null)
                experience.setTaches(new ArrayList<>());
            experience.getTaches().add(t);
        }

        return experienceRepository.save(experience);
    }

    @Override
    public Experience updateExperience(Experience c) {
        return experienceRepository.save(c);
    }

    @Override
    public List<Experience> listExperiences() {
        return experienceRepository.findAll();
    }

    @Override
    public void removeExperience(Experience c) {
        experienceRepository.delete(c);
    }

    @Override
    public void removeExperienceById(int id) {
        experienceRepository.delete(id);
    }

    @Override
    public List<Experience> findByDatedebut(Date dateDebut) {
        return experienceRepository.findByDatedebut(dateDebut);
    }

    @Override
    public List<Experience> findByDatefin(Date dateFin) {
        return experienceRepository.findByDatefin(dateFin);
    }

    @Override
    public List<Experience> findByCandidat(Candidat candidat) {
        return experienceRepository.findByCandidat(candidat);
    }

    @Override
    public List<Experience> findByProjet(Projet projet) {
        return experienceRepository.findByProjet(projet);
    }

    @Override
    public Experience findById(int id) {
        return experienceRepository.findById(id);
    }
}
