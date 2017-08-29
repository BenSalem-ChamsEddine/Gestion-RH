package de.cynapsys.repositories;

import de.cynapsys.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CandidatRepository extends JpaRepository<Candidat,Integer> {
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
}
