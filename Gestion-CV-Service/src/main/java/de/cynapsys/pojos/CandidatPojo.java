package de.cynapsys.pojos;

import de.cynapsys.entities.Certification;

import java.util.List;

public class CandidatPojo {

    private String nom;
    private String niveauExperience;
    private List<LanguePojo> listLangue;
    private List<CompetencePojo> listCompetence;
    private List<ExperiencePojo> listExperience;
    private List<CertificationPojo> listCertification;
    private List<FormationPojo> listFormation;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNiveauExperience() {
        return niveauExperience;
    }

    public void setNiveauExperience(String niveauExperience) {
        this.niveauExperience = niveauExperience;
    }

    public List<LanguePojo> getListLangue() {
        return listLangue;
    }

    public void setListLangue(List<LanguePojo> listLangue) {
        this.listLangue = listLangue;
    }

    public List<CompetencePojo> getListCompetence() {
        return listCompetence;
    }

    public void setListCompetence(List<CompetencePojo> listCompetence) {
        this.listCompetence = listCompetence;
    }

    public List<ExperiencePojo> getListExperience() {
        return listExperience;
    }

    public void setListExperience(List<ExperiencePojo> listExperience) {
        this.listExperience = listExperience;
    }

    public List<CertificationPojo> getListCertification() {
        return listCertification;
    }

    public void setListCertification(List<CertificationPojo> listCertification) {
        this.listCertification = listCertification;
    }

    public List<FormationPojo> getListFormation() {
        return listFormation;
    }

    public void setListFormation(List<FormationPojo> listFormation) {
        this.listFormation = listFormation;
    }
}
