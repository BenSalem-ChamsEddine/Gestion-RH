package de.cynapsys.GestionEntretienService.controlleurs;

import de.cynapsys.GestionEntretienService.entities.Candidat;
import de.cynapsys.GestionEntretienService.entities.Entretien;
import de.cynapsys.GestionEntretienService.services.EntretienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class EntretienRestService {

	@Autowired
	private EntretienService entretienService;

	@RequestMapping(value="/entretiens/addEntretien",method=RequestMethod.POST)
	@ResponseBody
	public Entretien saveEntretien(@RequestBody Entretien c) {
		return entretienService.saveEntretien(c);
	}

	@RequestMapping(value="/entretiens/updateEntretien",method=RequestMethod.PUT)
	@ResponseBody
	public Entretien updateEntretien(@RequestBody Entretien c) {
		return entretienService.saveEntretien(c);
	}
	
	@RequestMapping(value="/entretiens",method=RequestMethod.GET)
	@ResponseBody
	public List<Entretien> listEntretiens() {
		return entretienService.listEntretiens();
	}
	
	@RequestMapping(value="/entretiens/deleteEntretien",method=RequestMethod.DELETE)
	@ResponseBody
	public void deleteEntretien(@RequestBody Entretien c) {
		 entretienService.removeEntretien(c);
	}

	@RequestMapping(value="/candidats/deleteEntretienById/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public void deleteCandidatById(@PathVariable("id") int id) {
		entretienService.removeEntretienById(id);
	}

	@RequestMapping(value="/entretiens/findByCandidat/{id}",method=RequestMethod.GET)
	@ResponseBody
	public List<Entretien> findByCandidat(@PathVariable("id") int id) {
		return entretienService.findByCandidat(id);
	}

	@RequestMapping(value="/entretiens/findByDate/{date}",method=RequestMethod.GET)
	@ResponseBody
	public List<Entretien> findByDate(@PathVariable("date") Date date) {
		return entretienService.findByDate(date);
	}

	@RequestMapping(value="/entretiens/findById/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Entretien findById(@PathVariable("id") int id) {
		return entretienService.findById(id);
	}
}
