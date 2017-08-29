package de.cynapsys.GestionEntretienService.services;

import de.cynapsys.GestionEntretienService.entities.Candidat;
import de.cynapsys.GestionEntretienService.entities.Rendezvous;

import java.util.Date;
import java.util.List;


public interface RendezVousService {

	Rendezvous saveRendezVous(Rendezvous c);
	Rendezvous updateRendezVous(Rendezvous c);
	List<Rendezvous> listRendezVouss();
	void removeRendezVous(Rendezvous c);
	void removeRendezVousById(int id);
	List<Rendezvous> findByDateexamen(Date date);
	List<Rendezvous> findByDaterh(Date date);
	List<Rendezvous> findByResponsabletech(String responsable);
	List<Rendezvous> findByCandidat(Candidat c);
	Rendezvous findById(int id);
}
