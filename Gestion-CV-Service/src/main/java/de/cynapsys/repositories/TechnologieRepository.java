package de.cynapsys.repositories;

import de.cynapsys.entities.Competence;
import de.cynapsys.entities.Technologie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TechnologieRepository extends JpaRepository<Technologie,Integer> {

    Technologie findById(int id);
    List<Technologie> findByLibelle(String libelle);
    List<Technologie> findByCompetence(Competence competence);

}
