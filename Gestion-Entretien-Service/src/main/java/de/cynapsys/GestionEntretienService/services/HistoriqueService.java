package de.cynapsys.GestionEntretienService.services;

import de.cynapsys.GestionEntretienService.entities.*;

import java.util.List;

public interface HistoriqueService {

	Historique saveHistorique(Historique c);
	Historique updateHistorique(Historique c);
	List<Historique> listHistoriques();
	void removeHistorique(Historique c);
	void removeHistoriqueById(int id);
	List<Historique> findByExamen(Examen e);
	List<Historique> findByEntretien(Entretien e);
	List<Historique> findByCandidat(Candidat c);
	List<Historique> findByReponses(String reponses);
	List<Historique> findByQuestion(Question q);
	Historique findById(int id);
}
