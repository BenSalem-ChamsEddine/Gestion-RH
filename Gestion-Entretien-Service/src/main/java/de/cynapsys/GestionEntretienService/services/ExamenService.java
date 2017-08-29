package de.cynapsys.GestionEntretienService.services;

import de.cynapsys.GestionEntretienService.entities.Examen;

import java.util.List;

public interface ExamenService {

	Examen saveExamen(Examen c);
	Examen updateExamen(Examen c);
	List<Examen> listExamens();
	void removeExamen(Examen c);
	void removeExamenById(int id);
	List<Examen> findByNiveau(String niveau);
	List<Examen> findByPole(String pole);
	List<Examen> findByType(String type);
	Examen findById(int id);
}
