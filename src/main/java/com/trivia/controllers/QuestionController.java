package com.trivia.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.trivia.dao.QuestionDao;
import com.trivia.models.Question;



@RestController
@RequestMapping(value="/question")
public class QuestionController {

	private QuestionDao dao;
	@Autowired
	public QuestionController(QuestionDao dao) {
		super();
		this.dao = dao;
	}
	
	@RequestMapping(method=RequestMethod.GET) //Ensures a get request to /avenger (defined above) uses this method
	//@ResponseBody //this makes sure any data sent back in the body is in JSON format.
	public List<Question> assemble() {
		return Arrays.asList(dao.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Question> getOneQuestion(@PathVariable("id") int id) {
																				
		Question q = dao.getById(id);
		if(a==null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 
		}
		return ResponseEntity.status(HttpStatus.OK).body(q);
	}
	
	
	
}
