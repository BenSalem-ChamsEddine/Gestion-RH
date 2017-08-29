package de.cynapsys.servicesImpl;

import de.cynapsys.entities.Experience;
import de.cynapsys.entities.Tache;
import de.cynapsys.repositories.TacheRepository;
import de.cynapsys.services.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacheServiceImpl implements TacheService {

    @Autowired
    TacheRepository tacheRepository;

    @Override
    public Tache saveTache(Tache c) {
        c.setExperience(null);
        System.out.println(c);
        return tacheRepository.save(c);
    }

    @Override
    public Tache updateTache(Tache c) {
        return tacheRepository.save(c);
    }

    @Override
    public List<Tache> listTaches() {
        return tacheRepository.findAll();
    }

    @Override
    public void removeTache(Tache c) {
        tacheRepository.delete(c);
    }

    @Override
    public void removeTacheById(int id) {
        tacheRepository.delete(id);
    }

    @Override
    public List<Tache> findByLibelle(String libelle) {
        return tacheRepository.findByLibelle(libelle);
    }

    @Override
    public List<Tache> findByExperience(Experience experience) {
        return tacheRepository.findByExperience(experience);
    }

    @Override
    public Tache findById(int id) {
        return tacheRepository.findById(id);
    }
}
