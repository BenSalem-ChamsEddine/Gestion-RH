package de.cynapsys.GestionEntretienService.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the entretien database table.
 * 
 */
@Entity
@NamedQuery(name="Entretien.findAll", query="SELECT e FROM Entretien e")
public class Entretien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date date;

	//bi-directional many-to-one association to Candidat
	@ManyToOne
	@JoinColumn(name="can_id")
	private Candidat candidat;

	//bi-directional many-to-one association to Entretienexamen
	@OneToMany(mappedBy="entretien")
	@JsonIgnore
	private List<Entretienexamen> entretienexamens;

	//bi-directional many-to-one association to Historique
	@OneToMany(mappedBy="entretien")
	@JsonIgnore
	private List<Historique> historiques;

	public Entretien() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Candidat getCandidat() {
		return this.candidat;
	}

	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}

	public List<Entretienexamen> getEntretienexamens() {
		return this.entretienexamens;
	}

	public void setEntretienexamens(List<Entretienexamen> entretienexamens) {
		this.entretienexamens = entretienexamens;
	}

	public Entretienexamen addEntretienexamen(Entretienexamen entretienexamen) {
		getEntretienexamens().add(entretienexamen);
		entretienexamen.setEntretien(this);

		return entretienexamen;
	}

	public Entretienexamen removeEntretienexamen(Entretienexamen entretienexamen) {
		getEntretienexamens().remove(entretienexamen);
		entretienexamen.setEntretien(null);

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
		historique.setEntretien(this);

		return historique;
	}

	public Historique removeHistorique(Historique historique) {
		getHistoriques().remove(historique);
		historique.setEntretien(null);

		return historique;
	}

}