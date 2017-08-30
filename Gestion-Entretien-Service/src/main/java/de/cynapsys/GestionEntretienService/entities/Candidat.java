package de.cynapsys.GestionEntretienService.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
//import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the candidat database table.
 * 
 */
@Entity
@NamedQuery(name="Candidat.findAll", query="SELECT c FROM Candidat c")
public class Candidat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Long cin;

//	@Size(max = 200000)
	private String competences;

	private String cv;

	@Temporal(TemporalType.DATE)
	private Date datenaissance;

	private String email;

	@Lob
	@Type(type = "text")
	private String experiences;

	private Integer image;

	private String nom;

	private String prenom;

	private Long telephone;

	private String ville;


	//bi-directional many-to-one association to Entretien
	@OneToMany(mappedBy="candidat")
	@JsonIgnore
	private List<Entretien> entretiens;

	//bi-directional many-to-one association to Historique
	@OneToMany(mappedBy="candidat")
	@JsonIgnore
	private List<Historique> historiques;

	//bi-directional many-to-one association to Rendezvous
	@OneToMany(mappedBy="candidat")
	@JsonIgnore
	private List<Rendezvous> rendezvouses;

	public Candidat() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getCin() {
		return this.cin;
	}

	public void setCin(Long cin) {
		this.cin = cin;
	}

	public String getCompetences() {
		return this.competences;
	}

	public void setCompetences(String competences) {
		this.competences = competences;
	}

	public String getCv() {
		return this.cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public Date getDatenaissance() {
		return this.datenaissance;
	}

	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExperiences() {
		return this.experiences;
	}

	public void setExperiences(String experiences) {
		this.experiences = experiences;
	}

	public Integer getImage() {
		return this.image;
	}

	public void setImage(Integer image) {
		this.image = image;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Long getTelephone() {
		return this.telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<Entretien> getEntretiens() {
		return this.entretiens;
	}

	public void setEntretiens(List<Entretien> entretiens) {
		this.entretiens = entretiens;
	}

	public Entretien addEntretien(Entretien entretien) {
		getEntretiens().add(entretien);
		entretien.setCandidat(this);

		return entretien;
	}

	public Entretien removeEntretien(Entretien entretien) {
		getEntretiens().remove(entretien);
		entretien.setCandidat(null);

		return entretien;
	}

	public List<Historique> getHistoriques() {
		return this.historiques;
	}

	public void setHistoriques(List<Historique> historiques) {
		this.historiques = historiques;
	}

	public Historique addHistorique(Historique historique) {
		getHistoriques().add(historique);
		historique.setCandidat(this);

		return historique;
	}

	public Historique removeHistorique(Historique historique) {
		getHistoriques().remove(historique);
		historique.setCandidat(null);

		return historique;
	}

	public List<Rendezvous> getRendezvouses() {
		return this.rendezvouses;
	}

	public void setRendezvouses(List<Rendezvous> rendezvouses) {
		this.rendezvouses = rendezvouses;
	}

	public Rendezvous addRendezvous(Rendezvous rendezvous) {
		getRendezvouses().add(rendezvous);
		rendezvous.setCandidat(this);

		return rendezvous;
	}

	public Rendezvous removeRendezvous(Rendezvous rendezvous) {
		getRendezvouses().remove(rendezvous);
		rendezvous.setCandidat(null);

		return rendezvous;
	}

}