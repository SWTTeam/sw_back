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

import com.trivia.models.Score;
import com.trivia.services.ScoreService;

@RestController
@RequestMapping(value="/score")
@CrossOrigin
public class ScoreController {
	
	private static final Logger log = LogManager.getLogger(ScoreController.class);

	private ScoreService ss;

	@Autowired
	public ScoreController(ScoreService ss) {
		super();
		this.ss = ss;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Score> getOneScore(@PathVariable("id") int id) {
		
		log.info("in getOneScore(), about to enter ss.getById()");
		
		Score s = ss.getById(id);
		if (s==null) {
			
			log.info("s is null");
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			
			log.info("s is not null");
			
			return ResponseEntity.status(HttpStatus.OK).body(s);
		}
					
		
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Score>> getScore() {
		
		log.info("in getScore(), about to enter ss.getAll()");
		
		return ResponseEntity.status(HttpStatus.OK).body(ss.getAll());
	}
	
	@PostMapping
	public ResponseEntity<Boolean> insertScore(@RequestBody Score s) {
		
		log.info("in insertScore(), about to enter ss.storeScore()");
		
		if(ss.storeScore(s)) {
			
			log.info("leaving ss.storeScore, returning as 'true', back in insertScore()");
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
		} else {
			
			log.info("leaving ss.storeScore, returning as 'false', back in insertScore()");
			
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
		}
			
		
	}
	
	@PutMapping
	public ResponseEntity<Boolean> updateShowcase(@RequestBody Score s) {
		
		log.info("in updateShowcase(), about to enter ss.update()");
		
		if(ss.update(s)) {
			
			log.info("leaving ss.update, returning as 'true', back in updateShowcase()");
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
		} else {
			
			log.info("leaving ss.update, returning as 'false', back in updateShowcase()");
			
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
		}
			
		
	}
	
	@DeleteMapping
	public ResponseEntity<Boolean> deleteShowcase(@RequestBody Score s) {
		
		log.info("in deleteSchowcase(), about to enter ss.delete()");
		
		if(ss.delete(s)) {
			
			log.info("leaving ss.delete, returning as 'true', back in deleteShowcase()");
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
		} else {
			
			log.info("leaving ss.delete, returning as 'false', back in deleteShowcase()");
			
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
		}
			
		
	}
}
