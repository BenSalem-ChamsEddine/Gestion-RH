package de.cynapsys.GestionEntretienService.controlleurs;

import de.cynapsys.GestionEntretienService.entities.Entretienexamen;
import de.cynapsys.GestionEntretienService.entities.Examen;
import de.cynapsys.GestionEntretienService.serviceImpl.EmailSenderServiceImpl;
import de.cynapsys.GestionEntretienService.services.EntretienExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntretienExamenRestService {

	@Autowired
	private EntretienExamenService entretienexamenService;

	@Autowired
	private EmailSenderServiceImpl emailSenderService;

	@RequestMapping(value="/entrexam/addEntrexam",method=RequestMethod.POST)
	@ResponseBody
	public Entretienexamen saveEntretienexamen(@RequestBody Entretienexamen c) {
		return entretienexamenService.saveEntretienexamen(c);
	}
	@RequestMapping(value="/entrexam/updateEntrexam",method=RequestMethod.PUT)
	@ResponseBody
	public Entretienexamen updateEntretienexamen(@RequestBody Entretienexamen c) {
		return entretienexamenService.saveEntretienexamen(c);
	}
	
	@RequestMapping(value="/entrexam",method=RequestMethod.GET)
	@ResponseBody
	public List<Entretienexamen> listEntretienexamens() {
		return entretienexamenService.listEntretienexamens();
	}
	
	@RequestMapping(value="/entrexam/deleteEntrexam",method=RequestMethod.DELETE)
	@ResponseBody
	public void deleteEntretienexamen(@RequestBody Entretienexamen c) {
		 entretienexamenService.removeEntretienexamen(c);
	}

	@RequestMapping(value="/entrexam/deleteEntrexamById/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public void deleteEntretienexamenById(@PathVariable("id") int id) {
		entretienexamenService.removeEntretienexamenById(id);
	}

	@RequestMapping(value="/entrexam/findByEntretien/{id}",method=RequestMethod.GET)
	@ResponseBody
	public List<Entretienexamen> findByEntretien(@PathVariable("id") int id) {
		return entretienexamenService.findByEntretien(id);
	}

	@RequestMapping(value="/entrexam/findByExamen",method=RequestMethod.GET)
	@ResponseBody
	public List<Entretienexamen> findByExamen(@RequestBody Examen examen) {
		return entretienexamenService.findByExamen(examen);
	}

	@RequestMapping(value="/entrexam/findById/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Entretienexamen findById(@PathVariable int id) {
		return entretienexamenService.findById(id);
	}

	@RequestMapping(value="/entrexam/sendMail",method=RequestMethod.POST)
	@ResponseBody
	public boolean sendMail(@RequestBody Entretienexamen entretienexamen) {
		return emailSenderService.prepareAndSend(entretienexamen);
	}

}
