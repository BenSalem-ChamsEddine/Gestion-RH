package de.cynapsys.servicesImpl;

import de.cynapsys.entities.Projet;
import de.cynapsys.entities.Technologie;
import de.cynapsys.repositories.ProjetRepository;
import de.cynapsys.repositories.TechnologieRepository;
import de.cynapsys.services.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetServiceImpl implements ProjetService {

    @Autowired
    ProjetRepository projetRepository;
    @Autowired
    TechnologieRepository technologieRepository;

    @Override
    public Projet saveProjet(Projet c) {
        Projet projet = projetRepository.save(c);
        for (Technologie l: c.getTechnologies()) {
            int index = c.getTechnologies().indexOf(l);
            l= technologieRepository.findById(l.getId());
            l.getProjets().add(projet);
            c.getTechnologies().set(index,l);
            technologieRepository.save(l);
        }
        c.setTechnologies(c.getTechnologies());
        return projetRepository.save(c);
    }

    @Override
    public Projet updateProjet(Projet c) {
        return projetRepository.save(c);
    }

    @Override
    public List<Projet> listProjets() {
        return projetRepository.findAll();
    }

    @Override
    public void removeProjet(Projet c) {
        projetRepository.delete(c);
    }

    @Override
    public void removeProjetById(int id) {
        projetRepository.delete(id);
    }

    @Override
    public List<Projet> findByClient(String Client) {
        return projetRepository.findByClient(Client);
    }

    @Override
    public List<Projet> findByTitre(String titre) {
        return projetRepository.findByTitre(titre);
    }

    @Override
    public Projet findById(int id) {
        return projetRepository.findById(id);
    }
}
