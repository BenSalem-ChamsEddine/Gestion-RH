package de.cynapsys.controlleurs;

import de.cynapsys.entities.Affectation;
import de.cynapsys.entities.Candidat;
import de.cynapsys.services.AffectationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class AffectationController {

    @Autowired
    AffectationService affectationService;

    @RequestMapping(value = "/affectations/addAffectation", method = RequestMethod.POST)
    @ResponseBody
    public Affectation saveAffectation(@RequestBody Affectation c){
        return affectationService.saveAffectation(c);
    }

    @RequestMapping(value = "/affectations/updateAffectation", method = RequestMethod.PUT)
    @ResponseBody
    public Affectation updateAffectation(@RequestBody Affectation c){
        return affectationService.updateAffectation(c);
    }

    @RequestMapping(value = "/affectations", method = RequestMethod.GET)
    @ResponseBody
    public List<Affectation> listAffectations(){
        return affectationService.listAffectations();
    }

    @RequestMapping(value = "/affectations/deleteAffectation", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeAffectation(@RequestBody Affectation c){
        affectationService.removeAffectation(c);
    }

    @RequestMapping(value = "/affectations/deleteAffectation/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeAffectationById(@PathVariable("id") int id){
        affectationService.removeAffectationById(id);
    }

    @RequestMapping(value = "/affectations/findByCommercial/{commercial}", method = RequestMethod.GET)
    @ResponseBody
    public List<Affectation> findByCommercial(@PathVariable("commercial") String commercial){
        return affectationService.findByCommercial(commercial);
    }

    @RequestMapping(value = "/affectations/findByDatedebut/{dateDebut}", method = RequestMethod.GET)
    @ResponseBody
    public List<Affectation> findByDatedebut(@PathVariable("dateDebut") Date dateDebut){
        return affectationService.findByDatedebut(dateDebut);
    }

    @RequestMapping(value = "/affectations/findByDatefin/{dateFin}", method = RequestMethod.GET)
    @ResponseBody
    public List<Affectation> findByDatefin(@PathVariable("dateFin") Date dateFin){
        return affectationService.findByDatefin(dateFin);
    }

    @RequestMapping(value = "/affectations/findByCandidat", method = RequestMethod.GET)
    @ResponseBody
    public Affectation findByCandidat(@RequestBody Candidat candidat){
        return affectationService.findByCandidat(candidat);
    }

    @RequestMapping(value = "/affectations/findById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Affectation findById(@PathVariable("id") int id){
        return affectationService.findById(id);
    }
}
