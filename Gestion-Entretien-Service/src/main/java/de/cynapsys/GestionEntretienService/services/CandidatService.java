package de.cynapsys.GestionEntretienService.services;

import de.cynapsys.GestionEntretienService.entities.Candidat;

import java.util.List;

public interface CandidatService {

	
	Candidat saveCandidat(Candidat c);
	Candidat updateCandidat(Candidat c);
	List<Candidat> listCandidats();
	void removeCandidat(Candidat c);
	void removeCandidatById(int id);
	List<Candidat> findByCompetences(String competences);
	Candidat findByCin(long cin);
	Candidat findByEmail(String email);
	Candidat findById(int id);
}
