package de.cynapsys.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tache database table.
 * 
 */
@Entity
@NamedQuery(name="Tache.findAll", query="SELECT t FROM Tache t")
public class Tache implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String libelle;

	//bi-directional many-to-one association to Experience
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="exp_id")
	@JsonBackReference
	private Experience experience;

	@OneToMany(mappedBy = "tache",
			cascade = {CascadeType.ALL }, fetch = FetchType.LAZY)
	private List<Tache> taches;

	@ManyToOne (fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private Tache tache;

	public Tache() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Experience getExperience() {
		return experience;
	}

	public void setExperience(Experience experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "Tache{" +
				"id=" + id +
				", libelle='" + libelle + '\'' +
				", experience=" + experience +
				", taches=" + taches +
				", tache=" + tache +
				'}';
	}
}