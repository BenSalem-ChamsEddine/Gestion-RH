package de.cynapsys.GestionEntretienService.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the examen database table.
 * 
 */
@Entity
@NamedQuery(name="Examen.findAll", query="SELECT e FROM Examen e")
public class Examen implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String difficultee;

	private Integer duree;

	private String niveau;

	private String pole;

	private String type;

	//bi-directional many-to-one association to Entretienexamen
	@OneToMany(mappedBy="examen")
	@JsonIgnore
	private List<Entretienexamen> entretienexamens;

	//bi-directional many-to-one association to Historique
	@OneToMany(mappedBy="examen")
	@JsonIgnore
	private List<Historique> historiques;

	//bi-directional many-to-one association to Questionexamen
	@OneToMany(mappedBy="examen")
	@JsonManagedReference
	private List<Questionexamen> questionexamens;

	public Examen() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDifficultee() {
		return this.difficultee;
	}

	public void setDifficultee(String difficultee) {
		this.difficultee = difficultee;
	}

	public Integer getDuree() {
		return this.duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public String getNiveau() {
		return this.niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getPole() {
		return this.pole;
	}

	public void setPole(String pole) {
		this.pole = pole;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Entretienexamen> getEntretienexamens() {
		return this.entretienexamens;
	}

	public void setEntretienexamens(List<Entretienexamen> entretienexamens) {
		this.entretienexamens = entretienexamens;
	}

	public Entretienexamen addEntretienexamen(Entretienexamen entretienexamen) {
		getEntretienexamens().add(entretienexamen);
		entretienexamen.setExamen(this);

		return entretienexamen;
	}

	public Entretienexamen removeEntretienexamen(Entretienexamen entretienexamen) {
		getEntretienexamens().remove(entretienexamen);
		entretienexamen.setExamen(null);

		return entretienexamen;
	}

	public List<Historique> getHistoriques() {
		return this.historiques;
	}

	public void setHistoriques(List<Historique> historiques) {
		this.historiques = historiques;
	}

	public Historique addHistorique(Historique historique) {
		getHistoriques().add(historique);
		historique.setExamen(this);

		return historique;
	}

	public Historique removeHistorique(Historique historique) {
		getHistoriques().remove(historique);
		historique.setExamen(null);

		return historique;
	}

	public List<Questionexamen> getQuestionexamens() {
		return this.questionexamens;
	}

	public void setQuestionexamens(List<Questionexamen> questionexamens) {
		this.questionexamens = questionexamens;
	}

	public Questionexamen addQuestionexamen(Questionexamen questionexamen) {
		getQuestionexamens().add(questionexamen);
		questionexamen.setExamen(this);

		return questionexamen;
	}

	public Questionexamen removeQuestionexamen(Questionexamen questionexamen) {
		getQuestionexamens().remove(questionexamen);
		questionexamen.setExamen(null);

		return questionexamen;
	}

}