package de.cynapsys.GestionEntretienService.controlleurs;

import de.cynapsys.GestionEntretienService.entities.Candidat;
import de.cynapsys.GestionEntretienService.entities.Rendezvous;
import de.cynapsys.GestionEntretienService.services.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class RendezVousRestService {

	@Autowired
	private RendezVousService rendezVousService;

	@RequestMapping(value = "/rendezvous/addRendezVous", method = RequestMethod.POST)
	@ResponseBody
	public Rendezvous saveRendezVous(@RequestBody Rendezvous c) {
		return rendezVousService.saveRendezVous(c);
	}

	@RequestMapping(value = "/rendezvous/updateRendezVous", method = RequestMethod.PUT)
	@ResponseBody
	public Rendezvous updateRendezVous(@RequestBody Rendezvous c) {
		return rendezVousService.saveRendezVous(c);
	}

	@RequestMapping(value = "/rendezvous", method = RequestMethod.GET)
	@ResponseBody
	public List<Rendezvous> listRendezVouss() {
		return rendezVousService.listRendezVouss();
	}

	@RequestMapping(value = "/rendezvous/deleteRendezVous", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteRendezVous(@RequestBody Rendezvous c) {
		 rendezVousService.removeRendezVous(c);
	}

	@RequestMapping(value = "/rendezvous/deleteRendezVousById/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteRendezVousById(@PathVariable("id") int id) {
		rendezVousService.removeRendezVousById(id);
	}

	@RequestMapping(value = "/rendezvous/findByCandidat", method = RequestMethod.GET)
	@ResponseBody
	public void findByCandidat(@RequestBody Candidat candidat) {
		rendezVousService.findByCandidat(candidat);
	}

	@RequestMapping(value = "/rendezvous/findByDateexamen/{date}", method = RequestMethod.GET)
	@ResponseBody
	public void findByDateexamen(@PathVariable("date") Date date) {
		rendezVousService.findByDateexamen(date);
	}

	@RequestMapping(value = "/rendezvous/findByDaterh/{date}", method = RequestMethod.GET)
	@ResponseBody
	public void findByDaterh(@PathVariable("date") Date date) {
		rendezVousService.findByDaterh(date);
	}

	@RequestMapping(value = "/rendezvous/findByResponsabletech/{responsable}", method = RequestMethod.GET)
	@ResponseBody
	public void findByResponsabletech(@PathVariable("responsable") String responsable) {
		rendezVousService.findByResponsabletech(responsable);
	}

	@RequestMapping(value = "/rendezvous/findById/{id}", method = RequestMethod.GET)
	@ResponseBody
	public void findById(@PathVariable("id") int id) {
		rendezVousService.findById(id);
	}

}

