package de.cynapsys.repositories;

import de.cynapsys.entities.Candidat;
import de.cynapsys.entities.Experience;
import de.cynapsys.entities.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience,Integer> {

    List<Experience> findByDatedebut(Date dateDebut);
    List<Experience> findByDatefin(Date dateFin);
    List<Experience> findByCandidat(Candidat candidat);
    List<Experience> findByProjet(Projet projet);
    Experience findById(int id);


}
