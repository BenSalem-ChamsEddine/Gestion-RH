package de.cynapsys.GestionEntretienService.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the rendezvous database table.
 * 
 */
@Entity
@NamedQuery(name="Rendezvous.findAll", query="SELECT r FROM Rendezvous r")
public class Rendezvous implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="CET")
	private Date dateexamen;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="CET")
	private Date daterh;

	private String description;

	private String responsabletech;

	//bi-directional many-to-one association to Candidat
	@ManyToOne
	@JoinColumn(name="can_id")
	private Candidat candidat;

	public Rendezvous() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateexamen() {
		return dateexamen;
	}

	public void setDateexamen(Date dateexamen) {
		this.dateexamen = dateexamen;
	}

	public Date getDaterh() {
		return daterh;
	}

	public void setDaterh(Date daterh) {
		this.daterh = daterh;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResponsabletech() {
		return responsabletech;
	}

	public void setResponsabletech(String responsabletech) {
		this.responsabletech = responsabletech;
	}

	public Candidat getCandidat() {
		return candidat;
	}

	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}
}