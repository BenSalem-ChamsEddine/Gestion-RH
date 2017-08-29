package de.cynapsys.GestionEntretienService.services;

import de.cynapsys.GestionEntretienService.entities.Entretienexamen;
import de.cynapsys.GestionEntretienService.entities.Examen;

import java.util.List;

public interface EntretienExamenService  {

	 Entretienexamen saveEntretienexamen(Entretienexamen c);
	 Entretienexamen updateEntretienexamen(Entretienexamen c);
	 List<Entretienexamen> listEntretienexamens();
	 void removeEntretienexamen(Entretienexamen c);
	 void removeEntretienexamenById(int id);
	 List<Entretienexamen> findByEntretien(int id);
	 List<Entretienexamen> findByExamen(Examen e);
	 Entretienexamen findById(int id);
}
