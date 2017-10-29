package de.cynapsys.GestionEntretienService.serviceImpl;

import de.cynapsys.GestionEntretienService.entities.Candidat;
import de.cynapsys.GestionEntretienService.entities.Rendezvous;
import de.cynapsys.GestionEntretienService.repositories.RendezVousRepository;
import de.cynapsys.GestionEntretienService.services.CandidatService;
import de.cynapsys.GestionEntretienService.services.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Chams Eddine on 14/06/2017.
 */

@Service
public class RendezVousServiceImpl implements RendezVousService {

    @Autowired
    RendezVousRepository rendezVousRepository;

    @Autowired
    EmailSenderServiceImpl emailSenderService;

    @Autowired
    CandidatService candidatService;

    @Override
    public Rendezvous saveRendezVous(Rendezvous c) {
        Candidat candidat = candidatService.findById(c.getCandidat().getId());
        c.setCandidat(null);
        Rendezvous rendezvous = rendezVousRepository.save(c);
        List<Rendezvous> rdvs = candidat.getRendezvouses();
        rdvs.add(rendezvous);
        candidat.setRendezvouses(rdvs);
        rendezvous.setCandidat(candidat);
        candidatService.saveCandidat(candidat);
        rendezVousRepository.save(rendezvous);

        emailSenderService.sendRdv(rendezvous);
        return rendezvous;
    }

    @Override
    public Rendezvous updateRendezVous(Rendezvous c) {
        return rendezVousRepository.save(c);
    }

    @Override
    public List<Rendezvous> listRendezVouss() {
        return rendezVousRepository.findAll();
    }

    @Override
    public void removeRendezVous(Rendezvous c) {
        rendezVousRepository.delete(c);
    }

    @Override
    public void removeRendezVousById(int id) {
        rendezVousRepository.delete(id);
    }

    @Override
    public List<Rendezvous> findByDateexamen(Date date) {
        return rendezVousRepository.findByDateexamen(date);
    }

    @Override
    public List<Rendezvous> findByDaterh(Date date) {
        return rendezVousRepository.findByDaterh(date);
    }

    @Override
    public List<Rendezvous> findByResponsabletech(String responsable) {
        return rendezVousRepository.findByResponsabletech(responsable);
    }

    @Override
    public List<Rendezvous> findByCandidat(Candidat c) {
        return rendezVousRepository.findByCandidat(c);
    }

    @Override
    public Rendezvous findById(int id) {
        return rendezVousRepository.findById(id);
    }
}
