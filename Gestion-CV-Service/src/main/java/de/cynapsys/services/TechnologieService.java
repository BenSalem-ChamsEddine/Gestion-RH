package de.cynapsys.services;

import de.cynapsys.entities.Competence;
import de.cynapsys.entities.Technologie;

import java.util.List;

public interface TechnologieService {
    Technologie saveTechnologie(Technologie c);
    Technologie updateTechnologie(Technologie c);
    List<Technologie> listTechnologies();
    void removeTechnologie(Technologie c);
    void removeTechnologieById(int id);
    Technologie findById(int id);
    List<Technologie> findByLibelle(String libelle);
    List<Technologie> findByCompetence(Competence competence);
}
