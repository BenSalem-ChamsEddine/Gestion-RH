package de.cynapsys.services;

import de.cynapsys.entities.*;
import net.sf.jasperreports.engine.JRException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface CandidatService {
    Candidat saveCandidat(Candidat c);
    Candidat updateCandidat(Candidat c);
    Candidat updateRemoveFormation(Candidat candidat, int idFormation);
    Candidat updateRemoveLangue (Candidat candidat, int idLangue);
    Candidat updateRemoveCertification (Candidat candidat, int idCertification);
    Candidat updateRemoveExperience (Candidat candidat, int idExperience);
    Candidat updateRemoveTechnologie (Candidat candidat, int idTechnologie);
    List<Candidat> listCandidats();
    void removeCandidat(Candidat c);
    void removeCandidatById(int id);
    Candidat findByTelephone(long telephone);
    List<Candidat> findByDateEmbauche(Date date);
    Candidat findByEmail(String email);
    Candidat findById(int id);
    List<Candidat> findByNiveauExperience(String niveau);
    List<Candidat> findBySituation(String situation);
    List<Candidat> findByNom(String nom);
    List<Candidat> findByPrenom(String prenom);
    List<Candidat> findByIntegritee(String integritee);
    List<Candidat> findByCertifications(Certification certification);
    List<Candidat> findByFormations(Formation formation);
    List<Candidat> findByLangues(Langue langue);
    List<Candidat> findByExperiences(Experience experience);
    List<Candidat> findByTechnologies(Technologie technologie);
    void imprimerCV(int idCandidat,String format, HttpServletResponse response)throws JRException, IOException;
}
