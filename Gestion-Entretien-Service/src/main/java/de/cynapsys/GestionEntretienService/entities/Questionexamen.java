package de.cynapsys.GestionEntretienService.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the questionexamen database table.
 * 
 */
@Entity
@NamedQuery(name="Questionexamen.findAll", query="SELECT q FROM Questionexamen q")
public class Questionexamen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	//bi-directional many-to-one association to Examen
	@ManyToOne
	@JoinColumn(name="exa_id")
	@JsonBackReference
	private Examen examen;

	//bi-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name="que_id")
	private Question question;

	public Questionexamen() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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