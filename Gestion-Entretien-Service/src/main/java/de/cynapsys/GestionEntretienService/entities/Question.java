package de.cynapsys.GestionEntretienService.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
//import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the question database table.
 * 
 */
@Entity
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

//	@Size(max = 200000)
	private String enonce;

	private String niveau;

	private String type;

	//bi-directional many-to-one association to Historique
	@OneToMany(mappedBy="question")
	@JsonIgnore
	private List<Historique> historiques;

	//bi-directional many-to-one association to Proposition
	@OneToMany(mappedBy="question")
	@JsonManagedReference
	private List<Proposition> propositions;

	//bi-directional many-to-one association to Questionexamen
	@OneToMany(mappedBy="question")
	@JsonIgnore
	private List<Questionexamen> questionexamens;

	public Question() {
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

	public String getNiveau() {
		return this.niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Historique> getHistoriques() {
		return this.historiques;
	}

	public void setHistoriques(List<Historique> historiques) {
		this.historiques = historiques;
	}

	public Historique addHistorique(Historique historique) {
		getHistoriques().add(historique);
		historique.setQuestion(this);

		return historique;
	}

	public Historique removeHistorique(Historique historique) {
		getHistoriques().remove(historique);
		historique.setQuestion(null);

		return historique;
	}

	public List<Proposition> getPropositions() {
		return this.propositions;
	}

	public void setPropositions(List<Proposition> propositions) {
		this.propositions = propositions;
	}

	public Proposition addProposition(Proposition proposition) {
		getPropositions().add(proposition);
		proposition.setQuestion(this);

		return proposition;
	}

	public Proposition removeProposition(Proposition proposition) {
		getPropositions().remove(proposition);
		proposition.setQuestion(null);

		return proposition;
	}

	public List<Questionexamen> getQuestionexamens() {
		return this.questionexamens;
	}

	public void setQuestionexamens(List<Questionexamen> questionexamens) {
		this.questionexamens = questionexamens;
	}

	public Questionexamen addQuestionexamen(Questionexamen questionexamen) {
		getQuestionexamens().add(questionexamen);
		questionexamen.setQuestion(this);

		return questionexamen;
	}

	public Questionexamen removeQuestionexamen(Questionexamen questionexamen) {
		getQuestionexamens().remove(questionexamen);
		questionexamen.setQuestion(null);

		return questionexamen;
	}

}