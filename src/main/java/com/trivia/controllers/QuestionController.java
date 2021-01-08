package com.trivia.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import com.trivia.services.QuestionService;

@RestController
@RequestMapping(value="/trivia")
@CrossOrigin
public class QuestionController {
	
	private static final Logger log = LogManager.getLogger(QuestionController.class); 

	private QuestionService qs;

	@Autowired
	public QuestionController(QuestionService qs) {
		super();
		this.qs = qs;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Question> getOneQuestion(@PathVariable("id") int id) {
		
		log.info("in getOneQuestion(), about to enter qs.getById()");
		
		Question q = qs.getById(id);
		
		log.info("leaving qs.getById(), back in getOneQuestion()");
		
		if (q==null) {
			
			log.info("q is null");
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();	
		} else {
			
			log.info("1 is not null");
			
			return ResponseEntity.status(HttpStatus.OK).body(q);
		}
			
		
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Question>> getQuestion() {
		
		log.info("in getQuestion(), about to return qs.getAll()");
		
		return ResponseEntity.status(HttpStatus.OK).body(qs.getAll());
	}
	
	@PostMapping
	public ResponseEntity<Boolean> insertQuestion(@RequestBody Question q) {
		
		log.info("in insertQuestion(), about to enter qs.storeQuestion()");
		
		if(qs.storeQuestion(q)) {
			
			log.info("qs.storeQuestion() returned 'true'");
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
		} else {
			
			log.info("qs.storeQuestion() returned 'false'");
			
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);	
		}
			
		
	}
	
	@PutMapping
	public ResponseEntity<Boolean> updateQuestion(@RequestBody Question q) {
		
		log.info("in updateQuestion(), about to enter qs.update()");
		
		if(qs.update(q)) {
			
			log.info("leaving qs.update(), returning 'true', back in updateQuestion()");
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
		} else {
			
			log.info("leaving qs.update(), returning 'false', back in updateQuestion()");
			
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
		}
			
		
	}
	
	@DeleteMapping
	public ResponseEntity<Boolean> deleteQuestion(@RequestBody Question q) {
		
		log.info("in deleteQuestion(), about to enter qs.delete()");
		
		if(qs.delete(q)) {
			
			log.info("leaving qs.delete(), returning 'true', back in deleteQuestion()");
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
		} else {
			
			log.info("leaving qs.delete(), returning 'false', back in deleteQuestion()");
			
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
		}
			
		
	}
}
