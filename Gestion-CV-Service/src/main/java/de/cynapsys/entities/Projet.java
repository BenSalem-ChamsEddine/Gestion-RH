package de.cynapsys.entities;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the projet database table.
 * 
 */
@Entity
@NamedQuery(name="Projet.findAll", query="SELECT p FROM Projet p")
public class Projet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String client;

	private String equipeprojet;

	private String titre;

	//bi-directional many-to-one association to Experience
	@OneToMany(mappedBy="projet")
	@JsonIgnore
	private List<Experience> experiences;

	//bi-directional many-to-many association to Technologie
	@ManyToMany(mappedBy="projets")
	private List<Technologie> technologies;

	public Projet() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClient() {
		return this.client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getEquipeprojet() {
		return this.equipeprojet;
	}

	public void setEquipeprojet(String equipeprojet) {
		this.equipeprojet = equipeprojet;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<Experience> getExperiences() {
		return this.experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public Experience addExperience(Experience experience) {
		getExperiences().add(experience);
		experience.setProjet(this);

		return experience;
	}

	public Experience removeExperience(Experience experience) {
		getExperiences().remove(experience);
		experience.setProjet(null);

		return experience;
	}

	public List<Technologie> getTechnologies() {
		return this.technologies;
	}

	public void setTechnologies(List<Technologie> technologies) {
		this.technologies = technologies;
	}

}