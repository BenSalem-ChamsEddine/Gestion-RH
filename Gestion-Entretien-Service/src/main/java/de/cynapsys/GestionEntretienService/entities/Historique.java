package de.cynapsys.GestionEntretienService.entities;

import javax.persistence.*;
//import javax.validation.constraints.Size;
import java.io.Serializable;


/**
 * The persistent class for the historique database table.
 * 
 */
@Entity
@NamedQuery(name="Historique.findAll", query="SELECT h FROM Historique h")
public class Historique implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

//	@Size(max = 200000)
	private String reponses;

	//bi-directional many-to-one association to Candidat
	@ManyToOne
	@JoinColumn(name="can_id")
	private Candidat candidat;

	//bi-directional many-to-one association to Entretien
	@ManyToOne
	@JoinColumn(name="ent_id")
	private Entretien entretien;

	//bi-directional many-to-one association to Examen
	@ManyToOne
	@JoinColumn(name="exa_id")
	private Examen examen;

	//bi-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name="que_id")
	private Question question;

	public Historique() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReponses() {
		return this.reponses;
	}

	public void setReponses(String reponses) {
		this.reponses = reponses;
	}

	public Candidat getCandidat() {
		return this.candidat;
	}

	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
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

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}