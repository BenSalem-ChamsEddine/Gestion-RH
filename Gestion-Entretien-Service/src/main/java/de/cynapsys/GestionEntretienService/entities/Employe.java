package de.cynapsys.GestionEntretienService.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the employe database table.
 * 
 */
@Entity
@NamedQuery(name="Employe.findAll", query="SELECT e FROM Employe e")
public class Employe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private Boolean actif;

	private Boolean consultant;

	private BigDecimal cv;

	@Temporal(TemporalType.DATE)
	@Column(name="d_finstage")
	private Date dFinstage;

	@Temporal(TemporalType.DATE)
	@Column(name="d_recrutement")
	private Date dRecrutement;

	@Temporal(TemporalType.DATE)
	@Column(name="d_sortie")
	private Date dSortie;

	@Temporal(TemporalType.DATE)
	@Column(name="d_stage")
	private Date dStage;

	@Temporal(TemporalType.DATE)
	@Column(name="date_cin")
	private Date dateCin;

	@Temporal(TemporalType.DATE)
	@Column(name="date_debut_visa")
	private Date dateDebutVisa;

	@Temporal(TemporalType.DATE)
	@Column(name="date_fin_visa")
	private Date dateFinVisa;

	@Temporal(TemporalType.DATE)
	@Column(name="date_naissance")
	private Date dateNaissance;

	@Column(name="duree_sejour")
	private Integer dureeSejour;

	@Column(name="duree_sejour_consommer")
	private Integer dureeSejourConsommer;

	private Integer enfant;

	@Column(name="experience_a_embauche")
	private BigDecimal experienceAEmbauche;

	private BigDecimal idpointage;

	@Column(name="lieu_naissance")
	private String lieuNaissance;

	private String login;

	private String mail;

	@Column(name="matr_sociale")
	private BigDecimal matrSociale;

	private Integer matricule;

	private String mp;

	private String nationalite;

	private String nom;

	@Column(name="num_cin")
	private Integer numCin;

	private Integer poste;

	private String prenom;

	@Column(name="pro_id")
	private BigDecimal proId;

	private Integer sexe;

	@Column(name="sit_famille")
	private String sitFamille;

	private String telephone;

	@Column(name="telephone_mobile_1")
	private String telephoneMobile1;

	@Column(name="telephone_mobile_2")
	private String telephoneMobile2;

	public Employe() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Boolean getActif() {
		return this.actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	public Boolean getConsultant() {
		return this.consultant;
	}

	public void setConsultant(Boolean consultant) {
		this.consultant = consultant;
	}

	public BigDecimal getCv() {
		return this.cv;
	}

	public void setCv(BigDecimal cv) {
		this.cv = cv;
	}

	public Date getDFinstage() {
		return this.dFinstage;
	}

	public void setDFinstage(Date dFinstage) {
		this.dFinstage = dFinstage;
	}

	public Date getDRecrutement() {
		return this.dRecrutement;
	}

	public void setDRecrutement(Date dRecrutement) {
		this.dRecrutement = dRecrutement;
	}

	public Date getDSortie() {
		return this.dSortie;
	}

	public void setDSortie(Date dSortie) {
		this.dSortie = dSortie;
	}

	public Date getDStage() {
		return this.dStage;
	}

	public void setDStage(Date dStage) {
		this.dStage = dStage;
	}

	public Date getDateCin() {
		return this.dateCin;
	}

	public void setDateCin(Date dateCin) {
		this.dateCin = dateCin;
	}

	public Date getDateDebutVisa() {
		return this.dateDebutVisa;
	}

	public void setDateDebutVisa(Date dateDebutVisa) {
		this.dateDebutVisa = dateDebutVisa;
	}

	public Date getDateFinVisa() {
		return this.dateFinVisa;
	}

	public void setDateFinVisa(Date dateFinVisa) {
		this.dateFinVisa = dateFinVisa;
	}

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Integer getDureeSejour() {
		return this.dureeSejour;
	}

	public void setDureeSejour(Integer dureeSejour) {
		this.dureeSejour = dureeSejour;
	}

	public Integer getDureeSejourConsommer() {
		return this.dureeSejourConsommer;
	}

	public void setDureeSejourConsommer(Integer dureeSejourConsommer) {
		this.dureeSejourConsommer = dureeSejourConsommer;
	}

	public Integer getEnfant() {
		return this.enfant;
	}

	public void setEnfant(Integer enfant) {
		this.enfant = enfant;
	}

	public BigDecimal getExperienceAEmbauche() {
		return this.experienceAEmbauche;
	}

	public void setExperienceAEmbauche(BigDecimal experienceAEmbauche) {
		this.experienceAEmbauche = experienceAEmbauche;
	}

	public BigDecimal getIdpointage() {
		return this.idpointage;
	}

	public void setIdpointage(BigDecimal idpointage) {
		this.idpointage = idpointage;
	}

	public String getLieuNaissance() {
		return this.lieuNaissance;
	}

	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public BigDecimal getMatrSociale() {
		return this.matrSociale;
	}

	public void setMatrSociale(BigDecimal matrSociale) {
		this.matrSociale = matrSociale;
	}

	public Integer getMatricule() {
		return this.matricule;
	}

	public void setMatricule(Integer matricule) {
		this.matricule = matricule;
	}

	public String getMp() {
		return this.mp;
	}

	public void setMp(String mp) {
		this.mp = mp;
	}

	public String getNationalite() {
		return this.nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getNumCin() {
		return this.numCin;
	}

	public void setNumCin(Integer numCin) {
		this.numCin = numCin;
	}

	public Integer getPoste() {
		return this.poste;
	}

	public void setPoste(Integer poste) {
		this.poste = poste;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public BigDecimal getProId() {
		return this.proId;
	}

	public void setProId(BigDecimal proId) {
		this.proId = proId;
	}

	public Integer getSexe() {
		return this.sexe;
	}

	public void setSexe(Integer sexe) {
		this.sexe = sexe;
	}

	public String getSitFamille() {
		return this.sitFamille;
	}

	public void setSitFamille(String sitFamille) {
		this.sitFamille = sitFamille;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTelephoneMobile1() {
		return this.telephoneMobile1;
	}

	public void setTelephoneMobile1(String telephoneMobile1) {
		this.telephoneMobile1 = telephoneMobile1;
	}

	public String getTelephoneMobile2() {
		return this.telephoneMobile2;
	}

	public void setTelephoneMobile2(String telephoneMobile2) {
		this.telephoneMobile2 = telephoneMobile2;
	}

}