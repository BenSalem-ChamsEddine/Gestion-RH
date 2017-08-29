package de.cynapsys.repositories;

import de.cynapsys.entities.Competence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompetenceRepository extends JpaRepository<Competence,Integer> {

    Competence findByLibelle(String libelle);
    Competence findById(int id);

}
