package de.cynapsys.GestionEntretienService.controlleurs;

import de.cynapsys.GestionEntretienService.entities.Question;
import de.cynapsys.GestionEntretienService.services.PropositionService;
import de.cynapsys.GestionEntretienService.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionRestService {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private PropositionService propositionService;

	@RequestMapping(value="/questions/addQuestion",method=RequestMethod.POST)
	@ResponseBody
	public Question saveQuestion(@RequestBody Question c) {
		return questionService.saveQuestion(c);
	}

	@RequestMapping(value="/questions/addQCMQuestion",method=RequestMethod.POST)
	@ResponseBody
	public Question saveQCMQuestion(@RequestBody Question c)  {
		return questionService.saveQCMQuestion(c);
	}

	@RequestMapping(value="/questions/updateQuestion",method=RequestMethod.PUT)
	@ResponseBody
	public Question updateQuestion(@RequestBody Question c) {
		return questionService.saveQuestion(c);
	}
	
	@RequestMapping(value="/questions",method=RequestMethod.GET)
	@ResponseBody
	public List<Question> listQuestions() {
		return questionService.listQuestions();
	}
	
	@RequestMapping(value="/questions/deleteQuestion",method=RequestMethod.DELETE)
	@ResponseBody
	public void deleteQuestion(@RequestBody Question c) {
		 questionService.removeQuestion(c);
	}

	@RequestMapping(value="/questions/deleteQuestionById",method=RequestMethod.DELETE)
	@ResponseBody
	public void deleteQuestion(@PathVariable("id") int id) {
		 questionService.removeQuestionById(id);
	}

	@RequestMapping(value="/questions/findByNiveau/{niveau}",method=RequestMethod.GET)
	@ResponseBody
	public void findByNiveau(@PathVariable("niveau") String niveau) {
		questionService.findByNiveau(niveau);
	}

	@RequestMapping(value="/questions/findByType/{type}",method=RequestMethod.GET)
	@ResponseBody
	public void findByType(@PathVariable("type") String type) {
		questionService.findByType(type);
	}

	@RequestMapping(value="/questions/findById/{id}",method=RequestMethod.GET)
	@ResponseBody
	public void findById(@PathVariable("id") int id) {
		questionService.findById(id);
	}
}
