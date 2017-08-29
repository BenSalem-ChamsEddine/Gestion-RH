package de.cynapsys.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the experience database table.
 * 
 */
@Entity
@NamedQuery(name="Experience.findAll", query="SELECT e FROM Experience e")
public class Experience implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date datedebut;

	@Temporal(TemporalType.DATE)
	private Date datefin;

	private String poste;

	//bi-directional many-to-one association to Candidat
	@ManyToOne
	@JoinColumn(name="can_id")
	private Candidat candidat;

	//bi-directional many-to-one association to Projet
	@ManyToOne
	@JoinColumn(name="pro_id")
	private Projet projet;

	//bi-directional many-to-one association to Tache
	@OneToMany(mappedBy="experience", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Tache> taches;

	public Experience() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDatedebut() {
		return this.datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public Date getDatefin() {
		return this.datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	public Candidat getCandidat() {
		return this.candidat;
	}

	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}

	public Projet getProjet() {
		return this.projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public List<Tache> getTaches() {
		return this.taches;
	}

	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}
}