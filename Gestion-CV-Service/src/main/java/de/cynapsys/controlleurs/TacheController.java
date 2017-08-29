package de.cynapsys.controlleurs;

import de.cynapsys.entities.Experience;
import de.cynapsys.entities.Tache;
import de.cynapsys.services.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TacheController {

    @Autowired
    TacheService tacheService;

    @RequestMapping(value = "/taches/addTache", method = RequestMethod.POST)
    @ResponseBody
    public Tache saveTache(@RequestBody Tache c){
        return tacheService.saveTache(c);
    }

    @RequestMapping(value = "/taches/updateTache", method = RequestMethod.PUT)
    @ResponseBody
    public Tache updateTache(@RequestBody Tache c){
        return tacheService.updateTache(c);
    }

    @RequestMapping(value = "/taches", method = RequestMethod.GET)
    @ResponseBody
    public List<Tache> listTaches(){
        return tacheService.listTaches();
    }

    @RequestMapping(value = "/taches/deleteTache", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeTache(@RequestBody Tache c){
        tacheService.removeTache(c);
    }

    @RequestMapping(value = "/taches/deleteTache/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeTacheById(@PathVariable("id") int id){
        tacheService.removeTacheById(id);
    }

    @RequestMapping(value = "/taches/findByLibelle/{libelle}", method = RequestMethod.GET)
    @ResponseBody
    public List<Tache> findByLibelle(@PathVariable("libelle") String libelle){
        return tacheService.findByLibelle(libelle);
    }

    @RequestMapping(value = "/taches/findByExperience", method = RequestMethod.GET)
    @ResponseBody
    public List<Tache> findByExperience(@RequestBody Experience experience){
        return tacheService.findByExperience(experience);
    }

    @RequestMapping(value = "/taches/findById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Tache findById(@PathVariable("id") int id){
        return tacheService.findById(id);
    }
}
