package de.cynapsys.GestionEntretienService.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
//import javax.validation.constraints.Size;
import java.io.Serializable;


/**
 * The persistent class for the proposition database table.
 * 
 */
@Entity
@NamedQuery(name="Proposition.findAll", query="SELECT p FROM Proposition p")
public class Proposition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

//	@Size(max = 200000)
	private String enonce;

	private Boolean validitee;

	//bi-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name="que_id")
	@JsonBackReference
	private Question question;

	public Proposition() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEnonce() {
		return this.enonce;
	}

	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}

	public Boolean getValiditee() {
		return this.validitee;
	}

	public void setValiditee(Boolean validitee) {
		this.validitee = validitee;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}