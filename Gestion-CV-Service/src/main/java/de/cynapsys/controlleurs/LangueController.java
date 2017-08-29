package de.cynapsys.controlleurs;

import de.cynapsys.entities.Langue;
import de.cynapsys.services.LangueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LangueController {

    @Autowired
    LangueService langueService;

    @RequestMapping(value = "/langues/addLangue", method = RequestMethod.POST)
    @ResponseBody
    public Langue saveLangue(@RequestBody Langue c){
        return langueService.saveLangue(c);
    }

    @RequestMapping(value = "/langues/updateLangue", method = RequestMethod.PUT)
    @ResponseBody
    public Langue updateLangue(@RequestBody Langue c){
        return langueService.updateLangue(c);
    }

    @RequestMapping(value = "/langues", method = RequestMethod.GET)
    @ResponseBody
    public List<Langue> listLangues(){
        return langueService.listLangues();
    }

    @RequestMapping(value = "/langues/deleteLangue", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeLangue(@RequestBody Langue c){
        langueService.removeLangue(c);
    }

    @RequestMapping(value = "/langues/deleteLangue/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeLangueById(@PathVariable("id") int id){
        langueService.removeLangueById(id);
    }

    @RequestMapping(value = "/langues/findByLibelle/{libelle}", method = RequestMethod.GET)
    @ResponseBody
    public List<Langue> findByLibelle(@PathVariable("libelle") String libelle){
        return langueService.findByLibelle(libelle);
    }

    @RequestMapping(value = "/langues/findById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Langue findById(int id){
        return langueService.findById(id);
    }
}
