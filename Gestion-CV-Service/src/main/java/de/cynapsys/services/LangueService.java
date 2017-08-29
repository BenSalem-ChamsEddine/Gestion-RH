package de.cynapsys.services;

import de.cynapsys.entities.Langue;

import java.util.List;

public interface LangueService {
    Langue saveLangue(Langue c);
    Langue updateLangue(Langue c);
    List<Langue> listLangues();
    void removeLangue(Langue c);
    void removeLangueById(int id);
    List<Langue> findByLibelle(String libelle);
    Langue findById(int id);
}
