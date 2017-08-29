package de.cynapsys.servicesImpl;

import de.cynapsys.entities.Certification;
import de.cynapsys.repositories.CertificationRepository;
import de.cynapsys.services.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CertificationServiceImpl implements CertificationService {

    @Autowired
    CertificationRepository certificationRepository;

    @Override
    public Certification saveCertification(Certification c) {
        return certificationRepository.save(c);
    }

    @Override
    public Certification updateCertification(Certification c) {
        return certificationRepository.save(c);
    }

    @Override
    public List<Certification> listCertifications() {
        return certificationRepository.findAll();
    }

    @Override
    public void removeCertification(Certification c) {
        certificationRepository.delete(c);
    }

    @Override
    public void removeCertificationById(int id) {
        certificationRepository.delete(id);
    }

    @Override
    public List<Certification> findByDate(Date dateCertification) {
        return certificationRepository.findByDate(dateCertification);
    }

    @Override
    public List<Certification> findByLibelle(String libelle) {
        return certificationRepository.findByLibelle(libelle);
    }

    @Override
    public List<Certification> findByLieu(String lieu) {
        return certificationRepository.findByLieu(lieu);
    }

    @Override
    public Certification findById(int id) {
        return certificationRepository.findById(id);
    }
}
