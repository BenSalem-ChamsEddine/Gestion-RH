package de.cynapsys.pojos;

import java.util.List;

public class ExperiencePojo {

    private String titreProjet;
    private List<TachePojo> listTache;
    private String client;
    private String dateExp;
    private String equipeProjet;
    private String technologiesPro;
    private String poste;

    public String getTitreProjet() {
        return titreProjet;
    }

    public void setTitreProjet(String titreProjet) {
        this.titreProjet = titreProjet;
    }

    public List<TachePojo> getListTache() {
        return listTache;
    }

    public void setListTache(List<TachePojo> listTache) {
        this.listTache = listTache;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getDateExp() {
        return dateExp;
    }

    public void setDateExp(String dateExp) {
        this.dateExp = dateExp;
    }

    public String getEquipeProjet() {
        return equipeProjet;
    }

    public void setEquipeProjet(String equipeProjet) {
        this.equipeProjet = equipeProjet;
    }

    public String getTechnologiesPro() {
        return technologiesPro;
    }

    public void setTechnologiesPro(String technologies) {
        this.technologiesPro = technologies;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }
}
