package de.cynapsys.GestionEntretienService.services;

import de.cynapsys.GestionEntretienService.entities.Candidat;
import de.cynapsys.GestionEntretienService.entities.Entretien;

import java.util.Date;
import java.util.List;

public interface EntretienService {

	Entretien saveEntretien(Entretien c);
	Entretien updateEntretien(Entretien c);
	List<Entretien> listEntretiens();
	void removeEntretien(Entretien c);
	void removeEntretienById(int id);
	List<Entretien> findByDate(Date d);
	List<Entretien> findByCandidat(int id);
	Entretien findById(int id);
}
