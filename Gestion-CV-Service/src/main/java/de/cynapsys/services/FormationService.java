package de.cynapsys.services;

import de.cynapsys.entities.Formation;

import java.util.Date;
import java.util.List;

public interface FormationService {
    Formation saveFormation(Formation c);
    Formation updateFormation(Formation c);
    List<Formation> listFormations();
    void removeFormation(Formation c);
    void removeFormationById(int id);
    List<Formation> findByLibelle(String libelle);
    List<Formation> findByLieu(String lieu);
    List<Formation> findByDatefin(Date dateFin);
    List<Formation> findByDatedebut(Date dateDebut);
    Formation findById(int id);
}
