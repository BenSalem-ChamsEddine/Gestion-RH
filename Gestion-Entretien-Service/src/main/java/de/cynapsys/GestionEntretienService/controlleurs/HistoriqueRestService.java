package de.cynapsys.GestionEntretienService.controlleurs;

import de.cynapsys.GestionEntretienService.entities.*;
import de.cynapsys.GestionEntretienService.services.HistoriqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HistoriqueRestService {

	@Autowired
	private HistoriqueService historiqueService;

	@RequestMapping(value="/historiques/addHistorique",method=RequestMethod.POST)
	@ResponseBody
	public Historique saveHistorique(@RequestBody Historique c) {
		return historiqueService.saveHistorique(c);
	}

	@RequestMapping(value="/historiques/updateHistorique",method=RequestMethod.PUT)
	@ResponseBody
	public Historique updateHistorique(@RequestBody Historique c) {
		return historiqueService.saveHistorique(c);
	}
	
	@RequestMapping(value="/historiques",method=RequestMethod.GET)
	@ResponseBody
	public List<Historique> listHistoriques() {
		return historiqueService.listHistoriques();
	}
	
	@RequestMapping(value="/historiques/deleteHistorique",method=RequestMethod.DELETE)
	@ResponseBody
	public void deleteHistorique(@RequestBody Historique c) {
		historiqueService.removeHistorique(c);
	}

	@RequestMapping(value="/historiques/deleteHistoriqueById/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public void deleteHistoriqueById(@PathVariable("id") int id) {
		historiqueService.removeHistoriqueById(id);
	}

	@RequestMapping(value="/historiques/findByCandidat",method=RequestMethod.GET)
	@ResponseBody
	public List<Historique> findByCandidat(@RequestBody Candidat candidat) {
		return historiqueService.findByCandidat(candidat);
	}

	@RequestMapping(value="/historiques/findByEntretien",method=RequestMethod.GET)
	@ResponseBody
	public List<Historique> findByEntretien(@RequestBody Entretien entretien) {
		return historiqueService.findByEntretien(entretien);
	}

	@RequestMapping(value="/historiques/findByExamen",method=RequestMethod.GET)
	@ResponseBody
	public List<Historique> findByExamen(@RequestBody Examen examen) {
		return historiqueService.findByExamen(examen);
	}

	@RequestMapping(value="/historiques/findByQuestion",method=RequestMethod.GET)
	@ResponseBody
	public List<Historique> findByQuestion(@RequestBody Question question) {
		return historiqueService.findByQuestion(question);
	}

	@RequestMapping(value="/historiques/findByReponses/{reponses}",method=RequestMethod.GET)
	@ResponseBody
	public List<Historique> findByReponses(@PathVariable("reponses") String reponses) {
		return historiqueService.findByReponses(reponses);
	}

	@RequestMapping(value="/historiques/findById/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Historique findById(@PathVariable("id") int id) {
		return historiqueService.findById(id);
	}
	
}
