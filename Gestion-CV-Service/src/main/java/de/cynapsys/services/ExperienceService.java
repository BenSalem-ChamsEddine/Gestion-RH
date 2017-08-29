package de.cynapsys.services;

import de.cynapsys.entities.Candidat;
import de.cynapsys.entities.Experience;
import de.cynapsys.entities.Projet;

import java.util.Date;
import java.util.List;

public interface ExperienceService {
    Experience saveExperience(Experience c);
    Experience updateExperience(Experience c);
    List<Experience> listExperiences();
    void removeExperience(Experience c);
    void removeExperienceById(int id);
    List<Experience> findByDatedebut(Date dateDebut);
    List<Experience> findByDatefin(Date dateFin);
    List<Experience> findByCandidat(Candidat candidat);
    List<Experience> findByProjet(Projet projet);
    Experience findById(int id);
}
