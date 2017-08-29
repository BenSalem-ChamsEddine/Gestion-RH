package de.cynapsys.GestionEntretienService.controlleurs;

import de.cynapsys.GestionEntretienService.entities.Candidat;
import de.cynapsys.GestionEntretienService.services.CandidatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CandidatRestService {

	private final Logger logger = LoggerFactory.getLogger(CandidatRestService.class);
	private static String UPLOADED_FOLDER = "C:\\Users\\Chams Eddine\\.WebStorm2017.1\\ng2-admin\\src\\app\\files";

	@Autowired
	private CandidatService candidatService;

	@RequestMapping(value = "/candidats/addCandidat", method = RequestMethod.POST)
	@ResponseBody
	public Candidat saveCandidat(@RequestBody Candidat c) {
		return candidatService.saveCandidat(c);
	}

	@RequestMapping(value = "/candidats/updateCandidat", method = RequestMethod.PUT)
	@ResponseBody
	public Candidat updateCandidat(@RequestBody Candidat c) {
		return candidatService.saveCandidat(c);
	}

	@RequestMapping(value = "/candidats", method = RequestMethod.GET)
	@ResponseBody
	public List<Candidat> listCandidats() {
		return candidatService.listCandidats();
	}

	@RequestMapping(value = "/candidats/deleteCandidat", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteCandidat(@RequestBody Candidat c) {
		candidatService.removeCandidat(c);
	}

	@RequestMapping(value = "/candidats/deleteCandidatById/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteCandidatById(@PathVariable("id") int id) {
		candidatService.removeCandidatById(id);
	}

	@RequestMapping(value = "/candidats/findByCompetence/{competence}", method = RequestMethod.GET)
	public List<Candidat> findByCompetences(@PathVariable("competence") String competence) {
		return candidatService.findByCompetences(competence);
	}

	@RequestMapping(value = "/candidats/findByCin/{cin}", method = RequestMethod.GET)
	public Candidat findByCin(@PathVariable("cin") long cin) {
		return candidatService.findByCin(cin);
	}

	@RequestMapping(value = "/candidats/findByEmail/{email:.+}", method = RequestMethod.GET)
	public Candidat findByEmail(@PathVariable("email") String email) {
		return candidatService.findByEmail(email);
	}

	@RequestMapping(value = "/candidats/findById/{id}", method = RequestMethod.GET)
	public Candidat findById(@PathVariable("id") int id) {
		return candidatService.findById(id);
	}

	@RequestMapping("/")
	public String index() {
		return "index.html";
	}


}
