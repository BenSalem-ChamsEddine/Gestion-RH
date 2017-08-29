package de.cynapsys.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.cynapsys.serialization.TechnologieSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the technologie database table.
 * 
 */
@Entity
@NamedQuery(name="Technologie.findAll", query="SELECT t FROM Technologie t")
@JsonSerialize(using = TechnologieSerializer.class)
public class Technologie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String libelle;

	//bi-directional many-to-many association to Projet
	@ManyToMany
	@JoinTable(
		name="projettechnologie"
		, joinColumns={
			@JoinColumn(name="id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="pro_id")
			}
		)
	private List<Projet> projets;


	//bi-directional many-to-many association to Candidat
	@ManyToMany
	@JoinTable(
			name="candidattechnologie"
			, joinColumns={
			@JoinColumn(name="tech_id")
	}
			, inverseJoinColumns={
			@JoinColumn(name="id")
	}
	)
	private List<Candidat> candidats;

	//bi-directional many-to-one association to Competence
	@ManyToOne
	@JoinColumn(name="com_id")
	private Competence competence;

	public Technologie() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Projet> getProjets() {
		return this.projets;
	}

	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}

	public Competence getCompetence() {
		return this.competence;
	}

	public void setCompetence(Competence competence) {
		this.competence = competence;
	}

	public List<Candidat> getCandidats() {
		return candidats;
	}

	public void setCandidats(List<Candidat> candidats) {
		this.candidats = candidats;
	}
}