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

import com.trivia.models.Score;

@RestController
@RequestMapping(value="/score")
@CrossOrigin
public class ScoreController {

	private ScoreService ss;

	@Autowired
	public ScoreController(ShowcaseService ss) {
		super();
		this.ss = ss;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Score> getOneScore(@PathVariable("id") int id) {
		Score s = ss.getById(id);
		if (s==null)
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();		
		return ResponseEntity.status(HttpStatus.OK).body(s);
	}

	@RequestMapping(method=RequestMethod.GET)
	public List<Score> getScore() {
		return ResponseEntity.status(HttpStatus.OK).body(ss.getAll());
	}
	
	@PostMapping
	public ResponseEntity<Boolean> insertScore(@RequestBody Score s) {
		if(ss.storeScore(s))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
	}
	
	@PutMapping
	public ResponseEntity<Boolean> updateShowcase(@RequestBody Score s) {
		if(ss.update(s))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
	}
	
	@DeleteMapping
	public ResponseEntity<Boolean> deleteShowcase(@RequestBody Score s) {
		if(ss.delete(s))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
	}
}
