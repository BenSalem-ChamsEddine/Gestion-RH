package de.cynapsys.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.cynapsys.serialization.CandidatSerializer;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the candidat database table.
 * 
 */
@Entity
@NamedQuery(name="Candidat.findAll", query="SELECT c FROM Candidat c")
@JsonSerialize(using = CandidatSerializer.class)
public class Candidat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Long telephone;

	@Temporal(TemporalType.DATE)
	private Date dateEmbauche;

	private String email;

	private String niveauExperience;

	private String nom;

	private String prenom;

	private String situation;

	private String integritee;

	//bi-directional many-to-one association to Affectation
	@OneToMany(mappedBy="candidat")
	private List<Affectation> affectations;

	//bi-directional many-to-many association to Certification
	@ManyToMany(mappedBy="candidats")
	private List<Certification> certifications;

	//bi-directional many-to-many association to Competence
	@ManyToMany(mappedBy="candidats")
	private List<Technologie> technologies;

	//bi-directional many-to-many association to Formation
	@ManyToMany(mappedBy="candidats")
	private List<Formation> formations;

	//bi-directional many-to-many association to Langue
	@ManyToMany(mappedBy="candidats", cascade = CascadeType.MERGE)
	private List<Langue> langues;

	//bi-directional many-to-one association to Experience
	@OneToMany(mappedBy="candidat")
	private List<Experience> experiences;

	public Candidat() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getTelephone() {
		return telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNiveauExperience() {
		return niveauExperience;
	}

	public void setNiveauExperience(String niveauExperience) {
		this.niveauExperience = niveauExperience;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public String getIntegritee() {
		return integritee;
	}

	public void setIntegritee(String integritee) {
		this.integritee = integritee;
	}

	public List<Affectation> getAffectations() {
		return affectations;
	}

	public void setAffectations(List<Affectation> affectations) {
		this.affectations = affectations;
	}

	public List<Certification> getCertifications() {
		return certifications;
	}

	public void setCertifications(List<Certification> certifications) {
		this.certifications = certifications;
	}

	public List<Technologie> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(List<Technologie> technologies) {
		this.technologies = technologies;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	public List<Langue> getLangues() {
		return langues;
	}

	public void setLangues(List<Langue> langues) {
		this.langues = langues;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public void removeLangue(Langue langue) {
		langues.remove(langue);
		langue.getCandidats().remove(this);
	}
}