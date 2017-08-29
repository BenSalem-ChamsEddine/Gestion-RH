package de.cynapsys.GestionEntretienService.services;

import de.cynapsys.GestionEntretienService.entities.Employe;

import java.util.List;

/**
 * Created by Chams Eddine on 22/06/2017.
 */

public interface EmployeService {

    Employe findById(Long id);
    Employe findByLoginAndMp(String login, String mp);
    Employe findByMail(String mail);
    List<Employe> findByNom(String nom);
    List<Employe> findByPrenom(String prenom);
    Employe findByMatricule(int matricule);
    Employe findByActif(boolean active);
    List<Employe> listEmployes();
}
