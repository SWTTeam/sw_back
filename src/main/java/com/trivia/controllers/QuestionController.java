package com.trivia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trivia.models.Question;

@RestController
@RequestMapping(value="trivia")
@CrossOrigin
public class QuestionController {

	private QuestionService qs;

	@Autowired
	public QuestionController(QuestionService qs) {
		super();
		this.qs = qs;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Question> getOneQuestion(@PathVariable("id") int id) {
		Question q = qs.getById(id);
		if (q==null)
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();		
		return ResponseEntity.status(HttpStatus.OK).body(q);
	}

	@RequestMapping(method=RequestMethod.GET)
	public List<Question> getQuestion() {
		return ResponseEntity.status(HttpStatus.OK).body(qs.getAll());
	}
	
	@PostMapping
	public ResponseEntity<Boolean> insertQuestion(@RequestBody Question q) {
		if(qs.storeQuestion(q))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
	}
	
	@PutMapping
	public ResponseEntity<Boolean> updateQuestion(@RequestBody Question q) {
		if(qs.update(q))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
	}
	
	@DeleteMapping
	public ResponseEntity<Boolean> deleteQuestion(@RequestBody Question q) {
		if(qs.delete(q))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
	}
}
