package de.cynapsys.GestionEntretienService.repositories;

import de.cynapsys.GestionEntretienService.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Chams Eddine on 22/06/2017.
 */
public interface EmployeRepository extends JpaRepository<Employe, Long> {

    Employe findById(Long id);
    Employe findByLoginAndMp(String login, String mp);
    Employe findByMail(String mail);
    List<Employe> findByNom(String nom);
    List<Employe> findByPrenom(String prenom);
    Employe findByMatricule(int matricule);
    Employe findByActif(boolean active);
}
