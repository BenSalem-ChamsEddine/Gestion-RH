package de.cynapsys.servicesImpl;

import de.cynapsys.entities.Formation;
import de.cynapsys.repositories.FormationRepository;
import de.cynapsys.services.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FormationServiceImpl implements FormationService {

    @Autowired
    FormationRepository formationRepository;

    @Override
    public Formation saveFormation(Formation c) {
        return formationRepository.save(c);
    }

    @Override
    public Formation updateFormation(Formation c) {
        return formationRepository.save(c);
    }

    @Override
    public List<Formation> listFormations() {
        return formationRepository.findAll();
    }

    @Override
    public void removeFormation(Formation c) {
        formationRepository.delete(c);
    }

    @Override
    public void removeFormationById(int id) {
        formationRepository.delete(id);
    }

    @Override
    public List<Formation> findByLibelle(String libelle) {
        return formationRepository.findByLibelle(libelle);
    }

    @Override
    public List<Formation> findByLieu(String lieu) {
        return formationRepository.findByLieu(lieu);
    }

    @Override
    public List<Formation> findByDatefin(Date dateFin) {
        return formationRepository.findByDatefin(dateFin);
    }

    @Override
    public List<Formation> findByDatedebut(Date dateDebut) {
        return formationRepository.findByDatedebut(dateDebut);
    }

    @Override
    public Formation findById(int id) {
        return formationRepository.findById(id);
    }
}
