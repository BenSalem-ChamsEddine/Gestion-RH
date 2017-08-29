package de.cynapsys.services;

import de.cynapsys.entities.Certification;

import java.util.Date;
import java.util.List;

public interface CertificationService {
    Certification saveCertification(Certification c);
    Certification updateCertification(Certification c);
    List<Certification> listCertifications();
    void removeCertification(Certification c);
    void removeCertificationById(int id);
    List<Certification> findByDate(Date dateCertification);
    List<Certification> findByLibelle(String libelle);
    List<Certification> findByLieu(String lieu);
    Certification findById(int id);
}
