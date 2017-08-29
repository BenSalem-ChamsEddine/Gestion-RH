package de.cynapsys.controlleurs;

import de.cynapsys.entities.Certification;
import de.cynapsys.services.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class CertificationController {

    @Autowired
    CertificationService certificationService;

    @RequestMapping(value = "/certifications/addCertification", method = RequestMethod.POST)
    @ResponseBody
    public Certification saveCertification(@RequestBody Certification c){
        return certificationService.saveCertification(c);
    }

    @RequestMapping(value = "/certifications/updateCertification", method = RequestMethod.PUT)
    @ResponseBody
    public Certification updateCertification(Certification c){
        return certificationService.updateCertification(c);
    }

    @RequestMapping(value = "/certifications", method = RequestMethod.GET)
    @ResponseBody
    public List<Certification> listCertifications(){
        return certificationService.listCertifications();
    }

    @RequestMapping(value = "/certifications/deleteCertification", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeCertification(@RequestBody Certification c){
        certificationService.removeCertification(c);
    }

    @RequestMapping(value = "/certifications/deleteCertification/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeCertificationById(@PathVariable("id") int id){
        certificationService.removeCertificationById(id);
    }

    @RequestMapping(value = "/certifications/findByDate/{dateCertification}", method = RequestMethod.GET)
    @ResponseBody
    public List<Certification> findByDate(@PathVariable("dateCertification") Date dateCertification){
        return certificationService.findByDate(dateCertification);
    }

    @RequestMapping(value = "/certifications/findByLibelle/{libelle}", method = RequestMethod.GET)
    @ResponseBody
    public List<Certification> findByLibelle(@PathVariable("libelle") String libelle){
        return certificationService.findByLibelle(libelle);
    }

    @RequestMapping(value = "/certifications/findByLieu/{lieu}", method = RequestMethod.GET)
    @ResponseBody
    public List<Certification> findByLieu(@PathVariable("lieu") String lieu){
        return certificationService.findByLieu(lieu);
    }

    @RequestMapping(value = "/certifications/findById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Certification findById(int id){
        return certificationService.findById(id);
    }
}
