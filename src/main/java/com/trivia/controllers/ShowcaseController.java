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

import com.trivia.models.Showcase;
import com.trivia.services.ShowcaseService;

@RestController
@RequestMapping(value="/showcase")
@CrossOrigin
public class ShowcaseController {

	private ShowcaseService scs;

	@Autowired
	public ShowcaseController(ShowcaseService scs) {
		super();
		this.scs = scs;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Showcase> getOneShowcase(@PathVariable("id") int id) {
		Showcase sc = scs.getById(id);
		if (sc==null) 
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();		
		return ResponseEntity.status(HttpStatus.OK).body(sc);
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Showcase>> getShowcase() {
		return ResponseEntity.status(HttpStatus.OK).body(scs.getAll());
	}
	
	@PostMapping
	public ResponseEntity<Boolean> insertShowcase(@RequestBody Showcase sc) {
		if(scs.storeShowcase(sc))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
	}
	
	@PutMapping
	public ResponseEntity<Boolean> updateShowcase(@RequestBody Showcase sc) {
		if(scs.update(sc))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
	}
	
	@DeleteMapping
	public ResponseEntity<Boolean> deleteShowcase(@RequestBody Showcase sc) {
		if(scs.delete(sc))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
	}
}
