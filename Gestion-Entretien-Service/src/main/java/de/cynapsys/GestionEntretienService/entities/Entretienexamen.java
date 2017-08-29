package de.cynapsys.GestionEntretienService.entities;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the entretienexamen database table.
 * 
 */
@Entity
@NamedQuery(name="Entretienexamen.findAll", query="SELECT e FROM Entretienexamen e")
public class Entretienexamen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private double resultat;

	//bi-directional many-to-one association to Entretien
	@ManyToOne
	@JoinColumn(name="ent_id")
	private Entretien entretien;

	//bi-directional many-to-one association to Examen
	@ManyToOne
	@JoinColumn(name="exa_id")
	private Examen examen;

	public Entretienexamen() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getResultat() {
		return this.resultat;
	}

	public void setResultat(double resultat) {
		this.resultat = resultat;
	}

	public Entretien getEntretien() {
		return this.entretien;
	}

	public void setEntretien(Entretien entretien) {
		this.entretien = entretien;
	}

	public Examen getExamen() {
		return this.examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

}