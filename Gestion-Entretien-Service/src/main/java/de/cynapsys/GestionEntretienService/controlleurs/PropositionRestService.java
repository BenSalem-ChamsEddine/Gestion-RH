package de.cynapsys.GestionEntretienService.controlleurs;

import de.cynapsys.GestionEntretienService.entities.Proposition;
import de.cynapsys.GestionEntretienService.entities.Question;
import de.cynapsys.GestionEntretienService.services.PropositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PropositionRestService {

	@Autowired
	private PropositionService propositionService;

	@RequestMapping(value="/propositions/addProposition",method=RequestMethod.POST)
	@ResponseBody
	public Proposition saveProposition(@RequestBody Proposition c) {
		return propositionService.saveProposition(c);
	}

	@RequestMapping(value="/propositions/updateProposition",method=RequestMethod.PUT)
	@ResponseBody
	public Proposition updateProposition(@RequestBody Proposition c) {
		return propositionService.saveProposition(c);
	}
	
	@RequestMapping(value="/propositions",method=RequestMethod.GET)
	@ResponseBody
	public List<Proposition> listPropositions() {
		return propositionService.listPropositions();
	}
	
	@RequestMapping(value="/propositions/deleteProposition",method=RequestMethod.DELETE)
	@ResponseBody
	public void deleteProposition(@RequestBody Proposition c) {
		 propositionService.removeProposition(c);
	}

	@RequestMapping(value="/propositions/deletePropositionById/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public void deletePropositionById(@PathVariable("id") int id) {
		 propositionService.removePropositionById(id);
	}

	@RequestMapping(value="/propositions/findByEnonce/{enonce}",method=RequestMethod.GET)
	@ResponseBody
	public List<Proposition> findByEnonce(@PathVariable("enonce") String enonce) {
		return propositionService.findByEnonce(enonce);
	}

	@RequestMapping(value="/propositions/findByQuestion",method=RequestMethod.GET)
	@ResponseBody
	public List<Proposition> findByQuestion(@RequestBody Question question) {
		return propositionService.findByQuestion(question);
	}

	@RequestMapping(value="/propositions/findByValiditee/{validitee}",method=RequestMethod.GET)
	@ResponseBody
	public List<Proposition> findByValiditee(@PathVariable("validitee") boolean validitee) {
		return propositionService.findByValiditee(validitee);
	}

	@RequestMapping(value="/propositions/findById/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Proposition findById(@PathVariable("id") int id) {
		return propositionService.findById(id);
	}

	@RequestMapping(value="/propositions/findByQuestion/{id}",method=RequestMethod.GET)
	@ResponseBody
	public List<Proposition> findByQuestion(@PathVariable("id") int id) {
		Question q = new Question();
		q.setId(id);
		return propositionService.findByQuestion(q);
	}
}