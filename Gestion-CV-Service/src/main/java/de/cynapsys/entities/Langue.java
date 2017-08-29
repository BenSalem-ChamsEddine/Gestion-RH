package de.cynapsys.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the langue database table.
 * 
 */
@Entity
@NamedQuery(name="Langue.findAll", query="SELECT l FROM Langue l")
public class Langue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String libelle;

	private String niveau;

	//bi-directional many-to-many association to Candidat
	@ManyToMany
	@JoinTable(
		name="candidatlangue"
		, joinColumns={
			@JoinColumn(name="lan_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id")
			}
		)
	private List<Candidat> candidats;

	public Langue() {
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

	public String getNiveau() {
		return this.niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public List<Candidat> getCandidats() {
		return this.candidats;
	}

	public void setCandidats(List<Candidat> candidats) {
		this.candidats = candidats;
	}

}