package de.cynapsys.controlleurs;

import de.cynapsys.entities.Candidat;
import de.cynapsys.entities.Experience;
import de.cynapsys.entities.Projet;
import de.cynapsys.services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ExperienceController {

    @Autowired
    ExperienceService experienceService;

    @RequestMapping(value = "/experiences/addExperience", method = RequestMethod.POST)
    @ResponseBody
    public Experience saveExperience(@RequestBody Experience c){
        return experienceService.saveExperience(c);
    }

    @RequestMapping(value = "/experiences/updateExperience", method = RequestMethod.PUT)
    @ResponseBody
    public Experience updateExperience(@RequestBody Experience c){
        return experienceService.updateExperience(c);
    }

    @RequestMapping(value = "/experiences", method = RequestMethod.GET)
    @ResponseBody
    public List<Experience> listExperiences(){
        return experienceService.listExperiences();
    }

    @RequestMapping(value = "/experiences/deleteExperience", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeExperience(@RequestBody Experience c){
        experienceService.removeExperience(c);
    }

    @RequestMapping(value = "/experiences/deleteExperience/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeExperienceById(@PathVariable("id") int id){
        experienceService.removeExperienceById(id);
    }

    @RequestMapping(value = "/experiences/findByDatedebut/{dateDebut}", method = RequestMethod.GET)
    @ResponseBody
    public List<Experience> findByDatedebut(@PathVariable("dateDebut") Date dateDebut){
        return experienceService.findByDatedebut(dateDebut);
    }

    @RequestMapping(value = "/experiences/findByDatefin/{dateFin}", method = RequestMethod.GET)
    @ResponseBody
    public List<Experience> findByDatefin(@PathVariable("dateFin") Date dateFin){
        return experienceService.findByDatefin(dateFin);
    }

    @RequestMapping(value = "/experiences/findByCandidat", method = RequestMethod.GET)
    @ResponseBody
    public List<Experience> findByCandidat(@RequestBody Candidat candidat){
        return experienceService.findByCandidat(candidat);
    }

    @RequestMapping(value = "/experiences/findByProjet", method = RequestMethod.GET)
    @ResponseBody
    public List<Experience> findByProjet(@RequestBody Projet projet){
        return experienceService.findByProjet(projet);
    }

    @RequestMapping(value = "/experiences/findById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Experience findById(@PathVariable("id") int id){
        return experienceService.findById(id);
    }
}
