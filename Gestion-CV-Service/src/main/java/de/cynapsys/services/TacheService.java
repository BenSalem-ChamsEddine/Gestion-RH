package de.cynapsys.services;

import de.cynapsys.entities.Experience;
import de.cynapsys.entities.Tache;

import java.util.List;

public interface TacheService {
    Tache saveTache(Tache c);
    Tache updateTache(Tache c);
    List<Tache> listTaches();
    void removeTache(Tache c);
    void removeTacheById(int id);
    List<Tache> findByLibelle(String libelle);
    List<Tache> findByExperience(Experience experience);
    Tache findById(int id);
}
