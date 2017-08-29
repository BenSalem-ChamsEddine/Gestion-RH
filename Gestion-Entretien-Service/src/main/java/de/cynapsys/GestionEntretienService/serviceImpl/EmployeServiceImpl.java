package de.cynapsys.GestionEntretienService.serviceImpl;

import de.cynapsys.GestionEntretienService.entities.Employe;
import de.cynapsys.GestionEntretienService.repositories.EmployeRepository;
import de.cynapsys.GestionEntretienService.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chams Eddine on 22/06/2017.
 */
@Service
public class EmployeServiceImpl implements EmployeService {

    @Autowired
    EmployeRepository employeRepository;
    @Override
    public Employe findById(Long id) {
        return employeRepository.findById(id);
    }

    @Override
    public Employe findByLoginAndMp(String login, String mp) {
        return employeRepository.findByLoginAndMp(login,mp);
    }

    @Override
    public Employe findByMail(String mail) {
        return employeRepository.findByMail(mail);
    }

    @Override
    public List<Employe> findByNom(String nom) {
        return employeRepository.findByNom(nom);
    }

    @Override
    public List<Employe> findByPrenom(String prenom) {
        return employeRepository.findByPrenom(prenom);
    }

    @Override
    public Employe findByMatricule(int matricule) {
        return employeRepository.findByMatricule(matricule);
    }

    @Override
    public Employe findByActif(boolean active) {
        return employeRepository.findByActif(active);
    }

    @Override
    public List<Employe> listEmployes() {
        return employeRepository.findAll();
    }
}
