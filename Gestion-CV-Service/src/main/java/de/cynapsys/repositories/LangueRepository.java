package de.cynapsys.repositories;

import de.cynapsys.entities.Langue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LangueRepository extends JpaRepository<Langue,Integer> {
    List<Langue> findByLibelle(String libelle);
    Langue findById(int id);

}
