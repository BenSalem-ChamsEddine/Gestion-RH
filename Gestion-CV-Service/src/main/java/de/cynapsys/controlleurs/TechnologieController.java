package de.cynapsys.controlleurs;

import de.cynapsys.entities.Competence;
import de.cynapsys.entities.Technologie;
import de.cynapsys.services.TechnologieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TechnologieController {

    @Autowired
    TechnologieService technologieService;

    @RequestMapping(value = "/technologies/addTechnologie", method = RequestMethod.POST)
    @ResponseBody
    public Technologie saveTechnologie(@RequestBody Technologie c){
        return technologieService.saveTechnologie(c);
    }

    @RequestMapping(value = "/technologies/updateTechnologie", method = RequestMethod.PUT)
    @ResponseBody
    public Technologie updateTechnologie(@RequestBody Technologie c){
        return technologieService.updateTechnologie(c);
    }

    @RequestMapping(value = "/technologies", method = RequestMethod.GET)
    @ResponseBody
    public List<Technologie> listTechnologies(){
        return technologieService.listTechnologies();
    }

    @RequestMapping(value = "/technologies/deleteTechnologie", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeTechnologie(@RequestBody Technologie c){
        technologieService.removeTechnologie(c);
    }

    @RequestMapping(value = "/technologies/deleteTechnologie/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeTechnologieById(@PathVariable("id") int id){
        technologieService.removeTechnologieById(id);
    }

    @RequestMapping(value = "/technologies/findById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Technologie findById(@PathVariable("id") int id){
        return technologieService.findById(id);
    }

    @RequestMapping(value = "/technologies/findByLibelle/{libelle}", method = RequestMethod.GET)
    @ResponseBody
    public List<Technologie> findByLibelle(@PathVariable("libelle") String libelle){
        return technologieService.findByLibelle(libelle);
    }
    @RequestMapping(value = "/technologies/findByCompetence", method = RequestMethod.GET)
    @ResponseBody
    public List<Technologie> findByCompetence(@RequestBody Competence competence){
        return technologieService.findByCompetence(competence);
    }
}
