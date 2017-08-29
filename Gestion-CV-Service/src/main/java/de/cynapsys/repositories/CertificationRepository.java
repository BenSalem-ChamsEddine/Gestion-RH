package de.cynapsys.repositories;

import de.cynapsys.entities.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CertificationRepository extends JpaRepository<Certification,Integer> {

    List<Certification> findByDate(Date dateCertification);
    List<Certification> findByLibelle(String libelle);
    List<Certification> findByLieu(String lieu);
    Certification findById(int id);

}
