package de.cynapsys.repositories;

import de.cynapsys.entities.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjetRepository extends JpaRepository<Projet,Integer> {

    List<Projet> findByClient(String Client);
    List<Projet> findByTitre(String titre);
    Projet findById(int id);

}
