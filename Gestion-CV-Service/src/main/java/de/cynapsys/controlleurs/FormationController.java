package de.cynapsys.controlleurs;

import de.cynapsys.entities.Formation;
import de.cynapsys.services.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class FormationController {

    @Autowired
    FormationService formationService;

    @RequestMapping(value = "/formations/addFormation", method = RequestMethod.POST)
    @ResponseBody
    public Formation saveFormation(@RequestBody Formation c){
        return formationService.saveFormation(c);
    }

    @RequestMapping(value = "/formations/updateFormation", method = RequestMethod.PUT)
    @ResponseBody
    public Formation updateFormation(@RequestBody Formation c){
        return formationService.updateFormation(c);
    }

    @RequestMapping(value = "/formations", method = RequestMethod.GET)
    @ResponseBody
    public List<Formation> listFormations(){
        return formationService.listFormations();
    }

    @RequestMapping(value = "/formations/deleteFormation", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeFormation(@RequestBody Formation c){
        formationService.removeFormation(c);
    }

    @RequestMapping(value = "/formations/deleteFormation/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeFormationById(@PathVariable("id") int id){
        formationService.removeFormationById(id);
    }

    @RequestMapping(value = "/formations/findByLibelle/{libelle}", method = RequestMethod.GET)
    @ResponseBody
    public List<Formation> findByLibelle(@PathVariable("libelle") String libelle){
        return formationService.findByLibelle(libelle);
    }

    @RequestMapping(value = "/formations/findByLieu/{lieu}", method = RequestMethod.GET)
    @ResponseBody
    public List<Formation> findByLieu(@PathVariable("lieu") String lieu){
        return formationService.findByLieu(lieu);
    }

    @RequestMapping(value = "/formations/findByDatefin/{dateFin}", method = RequestMethod.GET)
    @ResponseBody
    public List<Formation> findByDatefin(@PathVariable("dateFin") Date dateFin){
        return formationService.findByDatefin(dateFin);
    }

    @RequestMapping(value = "/formations/findByDatedebut/{dateDebut}", method = RequestMethod.GET)
    @ResponseBody
    public List<Formation> findByDatedebut(@PathVariable("dateDebut") Date dateDebut){
        return formationService.findByDatedebut(dateDebut);
    }

    @RequestMapping(value = "/formations/findById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Formation findById(@PathVariable("id") int id){
        return formationService.findById(id);
    }
}
