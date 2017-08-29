package de.cynapsys.GestionEntretienService.controlleurs;

import de.cynapsys.GestionEntretienService.entities.Employe;
import de.cynapsys.GestionEntretienService.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Chams Eddine on 22/06/2017.
 */
@RestController
public class EmployeRestService {

    @Autowired
    EmployeService employeService;

    @RequestMapping(value = "/employes/findById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Employe findById(@PathVariable("id") Long id){
        return employeService.findById(id);
    }

    @RequestMapping(value = "/employes/findByLoginAndMp/{login}/{mp}", method = RequestMethod.GET)
    @ResponseBody
    public Employe findByLoginAndMp(@PathVariable("login") String login, @PathVariable("mp") String mp){
        return employeService.findByLoginAndMp(login,mp);
    }

    @RequestMapping(value = "/employes/findByMail/{mail:.+}", method = RequestMethod.GET)
    @ResponseBody
    public Employe findByMail(@PathVariable("mail") String mail){
        return employeService.findByMail(mail);
    }

    @RequestMapping(value = "/employes/findByNom/{nom}", method = RequestMethod.GET)
    @ResponseBody
    public List<Employe> findByNom(@PathVariable("nom") String nom){
        return employeService.findByNom(nom);
    }

    @RequestMapping(value = "/employes/findByPrenom/{prenom}", method = RequestMethod.GET)
    @ResponseBody
    public List<Employe> findByPrenom(@PathVariable("prenom") String prenom){
        return employeService.findByPrenom(prenom);
    }

    @RequestMapping(value = "/employes/findByMatricule/{matricule}", method = RequestMethod.GET)
    @ResponseBody
    public Employe findByMatricule(@PathVariable("matricule") int matricule){
        return employeService.findByMatricule(matricule);
    }

    @RequestMapping(value = "/employes/findByActif/{active}", method = RequestMethod.GET)
    @ResponseBody
    public Employe findByActif(@PathVariable("active") boolean active){
        return employeService.findByActif(active);
    }

    @RequestMapping(value = "/employes", method = RequestMethod.GET)
    @ResponseBody
    public List<Employe> listEmployes(){
        return employeService.listEmployes();
    }

}
