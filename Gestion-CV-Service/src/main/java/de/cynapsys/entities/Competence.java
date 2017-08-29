package de.cynapsys.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the competence database table.
 * 
 */
@Entity
@NamedQuery(name="Competence.findAll", query="SELECT c FROM Competence c")
public class Competence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String libelle;

	//bi-directional many-to-one association to Technologie
	@OneToMany(mappedBy="competence")
	private List<Technologie> technologies;

	public Competence() {
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

	public List<Technologie> getTechnologies() {
		return this.technologies;
	}

	public void setTechnologies(List<Technologie> technologies) {
		this.technologies = technologies;
	}

	public Technologie addTechnology(Technologie technology) {
		getTechnologies().add(technology);
		technology.setCompetence(this);

		return technology;
	}

	public Technologie removeTechnology(Technologie technology) {
		getTechnologies().remove(technology);
		technology.setCompetence(null);

		return technology;
	}

}