package de.cynapsys.GestionEntretienService.repositories;

import de.cynapsys.GestionEntretienService.entities.Candidat;
import de.cynapsys.GestionEntretienService.entities.Rendezvous;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface RendezVousRepository extends JpaRepository<Rendezvous, Integer> {

	List<Rendezvous> findByDateexamen(Date date);
	List<Rendezvous> findByDaterh(Date date);
	List<Rendezvous> findByResponsabletech(String responsable);
	List<Rendezvous> findByCandidat(Candidat c);
	Rendezvous findById(int id);
}
