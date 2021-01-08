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

import com.trivia.models.Showcase;
import com.trivia.services.ShowcaseService;

@RestController
@RequestMapping(value="/showcase")
@CrossOrigin
public class ShowcaseController {
		
	private static final Logger log = LogManager.getLogger(ShowcaseController.class);

	private ShowcaseService scs;

	@Autowired
	public ShowcaseController(ShowcaseService scs) {
		super();
		this.scs = scs;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Showcase> getOneShowcase(@PathVariable("id") int id) {
		
		log.info("in getOneShowcase(), about to enter scs.getById()");
		
		Showcase sc = scs.getById(id);
		if (sc==null) {
			
			log.info("sc is null");
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			
			log.info("sc is not null");
			
			return ResponseEntity.status(HttpStatus.OK).body(sc);
		}
					
		
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Showcase>> getShowcase() {
		
		log.info("in getShowcase(), about to enter scs.getAll()");
		
		return ResponseEntity.status(HttpStatus.OK).body(scs.getAll());
	}
	
	@PostMapping
	public ResponseEntity<Boolean> insertShowcase(@RequestBody Showcase sc) {
		
		log.info("in insertShowcase(), about to enter scs.storeShowcase()");
		
		if(scs.storeShowcase(sc)) {
			
			log.info("leaving scs.storeShowcase, returning 'true', back in insertShowcase()");
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
		} else {
			
			log.info("leaving scs.storeShowcase, returning 'false', back in insertShowcase()");
			
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
		}
			
		
	}
	
	@PutMapping
	public ResponseEntity<Boolean> updateShowcase(@RequestBody Showcase sc) {
			
		log.info("in updateShowcase(), about to enter scs.update()");
		
		if(scs.update(sc)) {
			
			log.info("leaving scs.update, returning 'true', back in updateShowcase()");
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
		} else {
			
			log.info("leaving scs.update, returning 'false', back in updateShowcase()");
			
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
		}
			
		
	}
	
	@DeleteMapping
	public ResponseEntity<Boolean> deleteShowcase(@RequestBody Showcase sc) {
		
		log.info("in deleteShowcase(), about to enter scs.delete()");
		
		if(scs.delete(sc)) {
			
			log.info("leaving scs.delete, returning 'true', back in deleteShowcase()");
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
		} else {
			
			log.info("leaving scs.delete, returning 'false', back in deleteShowcase()");
			
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
		}
			
		
	}
}
