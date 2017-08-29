package de.cynapsys.repositories;

import de.cynapsys.entities.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface FormationRepository extends JpaRepository<Formation,Integer> {

    List<Formation> findByLibelle(String libelle);
    List<Formation> findByLieu(String lieu);
    List<Formation> findByDatefin(Date dateFin);
    List<Formation> findByDatedebut(Date dateDebut);
    Formation findById(int id);


}
