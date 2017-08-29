package de.cynapsys.services;

import de.cynapsys.entities.Projet;

import java.util.List;

public interface ProjetService {
    Projet saveProjet(Projet c);
    Projet updateProjet(Projet c);
    List<Projet> listProjets();
    void removeProjet(Projet c);
    void removeProjetById(int id);
    List<Projet> findByClient(String Client);
    List<Projet> findByTitre(String titre);
    Projet findById(int id);
}
