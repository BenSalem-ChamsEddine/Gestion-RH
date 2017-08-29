package de.cynapsys.controlleurs;

import de.cynapsys.entities.Competence;
import de.cynapsys.services.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompetenceController {

    @Autowired
    CompetenceService competenceService;

    @RequestMapping(value = "/competences/addCompetence", method = RequestMethod.POST)
    @ResponseBody
    public Competence saveCompetence(@RequestBody Competence c){
        return competenceService.saveCompetence(c);
    }

    @RequestMapping(value = "/competences/updateCompetence", method = RequestMethod.PUT)
    @ResponseBody
    public Competence updateCompetence(@RequestBody Competence c){
        return competenceService.updateCompetence(c);
    }

    @RequestMapping(value = "/competences", method = RequestMethod.GET)
    @ResponseBody
    public List<Competence> listCompetences(){
        return competenceService.listCompetences();
    }

    @RequestMapping(value = "/competences/deleteCompetence", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeCompetence(@RequestBody Competence c){
        competenceService.removeCompetence(c);
    }

    @RequestMapping(value = "/competences/deleteCompetence/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeCompetenceById(@PathVariable("id") int id){
        competenceService.removeCompetenceById(id);
    }

    @RequestMapping(value = "/competences/findByLibelle/{libelle}", method = RequestMethod.GET)
    @ResponseBody
    public Competence findByLibelle(@PathVariable("libelle") String libelle){
        return competenceService.findByLibelle(libelle);
    }
    @RequestMapping(value = "/competences/findById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Competence findById(@PathVariable("id") int id){
        return competenceService.findById(id);
    }
}
