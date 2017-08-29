package de.cynapsys.services;

import de.cynapsys.entities.Competence;

import java.util.List;

public interface CompetenceService {
    Competence saveCompetence(Competence c);
    Competence updateCompetence(Competence c);
    List<Competence> listCompetences();
    void removeCompetence(Competence c);
    void removeCompetenceById(int id);
    Competence findByLibelle(String libelle);
    Competence findById(int id);
}
