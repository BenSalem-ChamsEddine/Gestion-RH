package de.cynapsys.controlleurs;

import de.cynapsys.entities.Projet;
import de.cynapsys.services.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjetController {

    @Autowired
    ProjetService projetService;

    @RequestMapping(value = "/projets/addProjet", method = RequestMethod.POST)
    @ResponseBody
    public Projet saveProjet(@RequestBody Projet c){
        return projetService.saveProjet(c);
    }

    @RequestMapping(value = "/projets/updateProjet", method = RequestMethod.PUT)
    @ResponseBody
    public Projet updateProjet(@RequestBody Projet c){
        return projetService.updateProjet(c);
    }

    @RequestMapping(value = "/projets", method = RequestMethod.GET)
    @ResponseBody
    public List<Projet> listProjets(){
        return projetService.listProjets();
    }

    @RequestMapping(value = "/projets/deleteProjet", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeProjet(@RequestBody Projet c){
        projetService.removeProjet(c);
    }

    @RequestMapping(value = "/projets/deleteProjet/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeProjetById(@PathVariable("id") int id){
        projetService.removeProjetById(id);
    }

    @RequestMapping(value = "/projets/findByClient/{client}", method = RequestMethod.GET)
    @ResponseBody
    public List<Projet> findByClient(@PathVariable("client") String client){
        return projetService.findByClient(client);
    }

    @RequestMapping(value = "/projets/findByTitre/{titre}", method = RequestMethod.GET)
    @ResponseBody
    public List<Projet> findByTitre(@PathVariable("titre") String titre){
        return projetService.findByTitre(titre);
    }

    @RequestMapping(value = "/projets/findById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Projet findById(@PathVariable("id") int id){
        return projetService.findById(id);
    }
}
