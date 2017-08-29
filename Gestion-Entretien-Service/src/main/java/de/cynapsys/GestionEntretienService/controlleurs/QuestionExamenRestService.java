package de.cynapsys.GestionEntretienService.controlleurs;

import de.cynapsys.GestionEntretienService.entities.Examen;
import de.cynapsys.GestionEntretienService.entities.Question;
import de.cynapsys.GestionEntretienService.entities.Questionexamen;
import de.cynapsys.GestionEntretienService.services.QuestionExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionExamenRestService {

	@Autowired
	private QuestionExamenService questionExamenService;

	@RequestMapping(value="/questionaddQuestionexamexam/",method=RequestMethod.POST)
	@ResponseBody
	public Questionexamen saveQuestionexamen(@RequestBody Questionexamen c) {
		return questionExamenService.saveQuestionexamen(c);
	}
	@RequestMapping(value="/questionexam/updateQuestionexam",method=RequestMethod.PUT)
	@ResponseBody
	public Questionexamen updateQuestionexamen(@RequestBody Questionexamen c) {
		return questionExamenService.saveQuestionexamen(c);
	}
	
	@RequestMapping(value="/questionexam",method=RequestMethod.GET)
	@ResponseBody
	public List<Questionexamen> listQuestionexamens() {
		return questionExamenService.listQuestionexamens();
	}
	
	@RequestMapping(value="/questionexam/deleteQuestionexam",method=RequestMethod.DELETE)
	@ResponseBody
	public void deleteQuestionexamen(@RequestBody Questionexamen c) {
		 questionExamenService.removeQuestionexamen(c);
	}

	@RequestMapping(value="/questionexam/deleteQuestionexamById/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public void deleteQuestionexamen(@PathVariable("id") int id) {
		 questionExamenService.removeQuestionexamenById(id);
	}

	@RequestMapping(value="/questionexam/findByExamen/{id}",method=RequestMethod.GET)
	@ResponseBody
	public List<Questionexamen> findByExamen(@PathVariable("id") int id) {
		Examen examen = new Examen();
		examen.setId(id);
		return questionExamenService.findByExamen(examen);
	}

	@RequestMapping(value="/questionexam/findByQuestion",method=RequestMethod.GET)
	@ResponseBody
	public void findByQuestion(@RequestBody Question question) {
		questionExamenService.findByQuestion(question);
	}

	@RequestMapping(value="/questionexam/findById/{id}",method=RequestMethod.GET)
	@ResponseBody
	public void findById(@PathVariable("id") int id) {
		questionExamenService.findById(id);
	}
	
}
