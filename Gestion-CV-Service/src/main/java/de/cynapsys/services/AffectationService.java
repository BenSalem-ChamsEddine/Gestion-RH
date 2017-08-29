package de.cynapsys.services;

import de.cynapsys.entities.Affectation;
import de.cynapsys.entities.Candidat;

import java.util.Date;
import java.util.List;

public interface AffectationService {

    Affectation saveAffectation(Affectation c);
    Affectation updateAffectation(Affectation c);
    List<Affectation> listAffectations();
    void removeAffectation(Affectation c);
    void removeAffectationById(int id);
    List<Affectation> findByCommercial(String commercial);
    List<Affectation> findByDatedebut(Date dateDebut);
    List<Affectation> findByDatefin(Date dateFin);
    Affectation findByCandidat(Candidat candidat);
    Affectation findById(int id);
}
