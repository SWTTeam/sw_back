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
import org.springframework.web.bind.annotation.RestController;

import com.trivia.models.User;
import com.trivia.services.UserService;

@RestController
@RequestMapping(value = "/register")
@CrossOrigin
public class RegisterController {
	
	private static final Logger log = LogManager.getLogger(RegisterController.class);

	private UserService us;

	@Autowired
	public RegisterController(UserService us) {
		super();
		this.us = us;
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getOneUser(@PathVariable("id") int id) {
		
		log.info("in getOneUser(), about to enter us.getById()");
		
		User u = us.getById(id);
		if (u == null) {
			
			log.info("u is null");
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			
			log.info("u is not null");
			
			return ResponseEntity.status(HttpStatus.OK).body(u);
		}
			
		
	}

	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		
		log.info("in getUsers(), about to return us.getAll()");
		
		return ResponseEntity.status(HttpStatus.OK).body(us.getAll());
	}

	@SuppressWarnings("rawtypes")
	@PostMapping
	public ResponseEntity insertUser(@RequestBody User u) {
		
		log.info("in insertUser(), about to enter us.storeUser()");
		
		if (us.storeUser(u)) {
			
			log.info("leaving us.storeUser(), returning 'true', back in insertUser()");
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		} else {
			
			log.info("leaving us.storeUser(), returning 'false', back in insertUser()");
			
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}
	}

	@PutMapping
	public ResponseEntity<Boolean> updateUser(@RequestBody User u) {
		
		log.info("in updateUser(), about to enter us.update()");
		
		if (us.update(u)) {
			
			log.info("leaving us.update(), returning 'true', back in updateUser()");
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
		} else {
			
			log.info("leaving us.update(), returning 'false', back in updateUser()");
			
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
		}
			
		
	}

	@DeleteMapping
	public ResponseEntity<Boolean> deleteUser(@RequestBody User u) {
		
		log.info("in deleteUser(), about to enter us.delete()");
		
		if (us.delete(u)) {
			
			log.info("leaving us.delete(), returning 'true', back in updateUser()");
		
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
		} else {
			
			log.info("leaving us.delete(), returning 'false', back in updateUser()");
			
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
		}
			
		
	}
	
}
