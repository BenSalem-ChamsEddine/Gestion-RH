package de.cynapsys.repositories;

import de.cynapsys.entities.Affectation;
import de.cynapsys.entities.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AffectationRepository extends JpaRepository <Affectation,Integer> {

    List<Affectation> findByCommercial(String commercial);
    List<Affectation> findByDatedebut(Date dateDebut);
    List<Affectation> findByDatefin(Date dateFin);
    Affectation findByCandidat(Candidat candidat);
    Affectation findById(int id);


}
