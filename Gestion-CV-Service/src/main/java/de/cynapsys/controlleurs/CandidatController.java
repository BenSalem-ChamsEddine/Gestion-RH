package de.cynapsys.controlleurs;

import de.cynapsys.entities.*;
import de.cynapsys.services.CandidatService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
public class CandidatController {

    @Autowired
    CandidatService candidatService;

    @RequestMapping(value = "/candidats/addCandidat", method = RequestMethod.POST)
    @ResponseBody
    public Candidat saveCandidat(@RequestBody Candidat c){
        return candidatService.saveCandidat(c);
    }

    @RequestMapping(value = "/candidats/updateCandidat", method = RequestMethod.PUT)
    @ResponseBody
    public Candidat updateCandidat(@RequestBody Candidat c){
        return candidatService.updateCandidat(c);
    }

    @RequestMapping(value = "/candidats/updateRemoveFormation/{idFormation}", method = RequestMethod.PUT)
    @ResponseBody
    public Candidat updateRemoveFormation(@RequestBody Candidat c, @PathVariable("idFormation") int idFormation){
        return candidatService.updateRemoveFormation(c, idFormation);
    }

    @RequestMapping(value = "/candidats/updateRemoveLangue/{idLangue}", method = RequestMethod.PUT)
    @ResponseBody
    public Candidat updateRemoveLangue(@RequestBody Candidat c, @PathVariable("idLangue") int idLangue){
        return candidatService.updateRemoveLangue(c, idLangue);
    }

    @RequestMapping(value = "/candidats/updateRemoveCertification/{idCertification}", method = RequestMethod.PUT)
    @ResponseBody
    public Candidat updateRemoveCertification(@RequestBody Candidat c, @PathVariable("idCertification") int idCertification){
        return candidatService.updateRemoveCertification(c, idCertification);
    }

    @RequestMapping(value = "/candidats/updateRemoveExperience/{idExperience}", method = RequestMethod.PUT)
    @ResponseBody
    public Candidat updateRemoveExperience(@RequestBody Candidat c, @PathVariable("idExperience") int idExperience){
        return candidatService.updateRemoveExperience(c, idExperience);
    }

    @RequestMapping(value = "/candidats/updateRemoveTechnologie/{idTechnologie}", method = RequestMethod.PUT)
    @ResponseBody
    public Candidat updateRemoveTechnologie(@RequestBody Candidat c, @PathVariable("idTechnologie") int idTechnologie){
        return candidatService.updateRemoveTechnologie(c, idTechnologie);
    }

    @RequestMapping(value = "/candidats", method = RequestMethod.GET)
    @ResponseBody
    public List<Candidat> listCandidats(){
        return candidatService.listCandidats();
    }

    @RequestMapping(value = "/candidats/deleteCandidat", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeCandidat(@RequestBody Candidat c){
        candidatService.removeCandidat(c);
    }

    @RequestMapping(value = "/candidats/deleteCandidat/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeCandidatById(@PathVariable("id") int id){
        candidatService.removeCandidatById(id);
    }

    @RequestMapping(value = "/candidats/findByTelephone/{telephone}", method = RequestMethod.GET)
    @ResponseBody
    public Candidat findByTelephone(@PathVariable("telephone") long telephone){
        return candidatService.findByTelephone(telephone);
    }

    @RequestMapping(value = "/candidats/findByDateEmbauche/{date}", method = RequestMethod.GET)
    @ResponseBody
    public List<Candidat> findByDateEmbauche(@PathVariable("date") Date date){
        return candidatService.findByDateEmbauche(date);
    }

    @RequestMapping(value = "/candidats/findByEmail/{email}", method = RequestMethod.GET)
    @ResponseBody
    public Candidat findByEmail(@PathVariable("email") String email){
        return candidatService.findByEmail(email);
    }

    @RequestMapping(value = "/candidats/findById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Candidat findById(@PathVariable("id") int id){
        return candidatService.findById(id);
    }

    @RequestMapping(value = "/candidats/findByNiveauExperience/{niveau}", method = RequestMethod.GET)
    @ResponseBody
    public List<Candidat> findByNiveauExperience(@PathVariable("niveau") String niveau){
        return candidatService.findByNiveauExperience(niveau);
    }

    @RequestMapping(value = "/candidats/findBySituation/{situation}", method = RequestMethod.GET)
    @ResponseBody
    public List<Candidat> findBySituation(@PathVariable("situation") String situation){
        return candidatService.findBySituation(situation);
    }

    @RequestMapping(value = "/candidats/findByNom/{nom}", method = RequestMethod.GET)
    @ResponseBody
    public List<Candidat> findByNom(@PathVariable("nom") String nom){
        return candidatService.findByNom(nom);
    }

    @RequestMapping(value = "/candidats/findByPrenom/{prenom}", method = RequestMethod.GET)
    @ResponseBody
    public List<Candidat> findByPrenom(@PathVariable("prenom") String prenom){
        return candidatService.findByPrenom(prenom);
    }

    @RequestMapping(value = "/candidats/findByIntegritee/{integritee}", method = RequestMethod.GET)
    @ResponseBody
    List<Candidat> findByIntegritee(@PathVariable("integritee") String integritee){
        return candidatService.findByIntegritee(integritee);
    }

    @RequestMapping(value = "/candidats/findByCertifications", method = RequestMethod.GET)
    @ResponseBody
    public List<Candidat> findByCertifications(@RequestBody Certification certification){
        return candidatService.findByCertifications(certification);
    }

    @RequestMapping(value = "/candidats/findByFormations", method = RequestMethod.GET)
    @ResponseBody
    public List<Candidat> findByFormations(@RequestBody Formation formation){
        return candidatService.findByFormations(formation);
    }

    @RequestMapping(value = "/candidats/findByLangues", method = RequestMethod.GET)
    @ResponseBody
    public List<Candidat> findByLangues(@RequestBody Langue langue){
        return candidatService.findByLangues(langue);
    }

    @RequestMapping(value = "/candidats/findByExperiences", method = RequestMethod.GET)
    @ResponseBody
    public List<Candidat> findByExperiences(@RequestBody Experience experience){
        return candidatService.findByExperiences(experience);
    }

    @RequestMapping(value = "/candidats/findByTechnologie", method = RequestMethod.GET)
    @ResponseBody
    public List<Candidat> findByTechnologies(@RequestBody Technologie technologie) {
        return candidatService.findByTechnologies(technologie);
    }

    @RequestMapping(value = "/imprimercv/{idCandidat}/{format}")
    @ResponseBody
    public void imprimerCV(@PathVariable("idCandidat") int idCandidat, @PathVariable("format") String format, HttpServletResponse response) throws IOException, JRException {
        candidatService.imprimerCV(idCandidat,format, response);
    }
}
