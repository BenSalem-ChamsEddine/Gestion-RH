package de.cynapsys.servicesImpl;

import de.cynapsys.entities.Langue;
import de.cynapsys.repositories.LangueRepository;
import de.cynapsys.services.LangueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LangueServiceImpl implements LangueService {

    @Autowired
    LangueRepository langueRepository;

    @Override
    public Langue saveLangue(Langue c) {
        return langueRepository.save(c);
    }

    @Override
    public Langue updateLangue(Langue c) {
        return langueRepository.save(c);
    }

    @Override
    public List<Langue> listLangues() {
        return langueRepository.findAll();
    }

    @Override
    public void removeLangue(Langue c) {
        langueRepository.delete(c);
    }

    @Override
    public void removeLangueById(int id) {
        langueRepository.delete(id);
    }

    @Override
    public List<Langue> findByLibelle(String libelle) {
        return langueRepository.findByLibelle(libelle);
    }

    @Override
    public Langue findById(int id) {
        return langueRepository.findById(id);
    }
}
