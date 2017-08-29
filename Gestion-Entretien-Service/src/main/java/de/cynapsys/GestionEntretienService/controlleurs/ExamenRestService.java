package de.cynapsys.GestionEntretienService.controlleurs;

import de.cynapsys.GestionEntretienService.entities.Examen;
import de.cynapsys.GestionEntretienService.services.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExamenRestService {

	@Autowired
	private ExamenService examenService;

	@RequestMapping(value="/examens/addExamen",method=RequestMethod.POST)
	@ResponseBody
	public Examen saveExamen(@RequestBody Examen c) {
		return examenService.saveExamen(c);
	}

	@RequestMapping(value="/examens/updateExamen",method=RequestMethod.PUT)
	@ResponseBody
	public Examen updateExamen(@RequestBody Examen c) {
		return examenService.saveExamen(c);
	}
	
	@RequestMapping(value="/examens",method=RequestMethod.GET)
	@ResponseBody
	public List<Examen> listExamens() {
		return examenService.listExamens();
	}
	
	@RequestMapping(value="/examens/deleteExamen",method=RequestMethod.DELETE)
	@ResponseBody
	public void deleteExamen(@RequestBody Examen c) {
		examenService.removeExamen(c);
	}

	@RequestMapping(value="/examens/deleteExamenById/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public void deleteExamenById(@PathVariable("id") int id) {
		examenService.removeExamenById(id);
	}

	@RequestMapping(value="/examens/findByNiveau/{niveau}",method=RequestMethod.GET)
	@ResponseBody
	public List<Examen> findByNiveau(@PathVariable("niveau") String niveau) {
		return examenService.findByNiveau(niveau);
	}

	@RequestMapping(value="/examens/findByPole/{pole}",method=RequestMethod.GET)
	@ResponseBody
	public List<Examen> findByPole(@PathVariable("pole") String pole) {
		return examenService.findByPole(pole);
	}

	@RequestMapping(value="/examens/findByType/{type}",method=RequestMethod.GET)
	@ResponseBody
	public List<Examen> findByType(@PathVariable("type") String type) {
		return examenService.findByType(type);
	}

	@RequestMapping(value="/examens/findById/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Examen findById(@PathVariable("id") int id) {
		return examenService.findById(id);
	}
}
