package de.cynapsys.repositories;

import de.cynapsys.entities.Experience;
import de.cynapsys.entities.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TacheRepository extends JpaRepository<Tache,Integer> {

    List<Tache> findByLibelle(String libelle);
    List<Tache> findByExperience(Experience experience);
    Tache findById(int id);
}
