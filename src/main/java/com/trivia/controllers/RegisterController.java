package com.trivia.controllers;

import java.util.List;

import org.hibernate.SessionFactory;
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
import com.trivia.repos.UserDAO;
import com.trivia.repos.UserDAOPostgres;
import com.trivia.services.UserService;

@RestController
@RequestMapping(value = "/register")
@CrossOrigin
public class RegisterController {

	private UserService us;

	@Autowired
	public RegisterController(UserService us) {
		super();
		this.us = us;
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getOneUser(@PathVariable("id") int id) {
		User u = us.getById(id);
		if (u == null)
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.status(HttpStatus.OK).body(u);
	}

	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		return ResponseEntity.status(HttpStatus.OK).body(us.getAll());
	}

	@PostMapping
	public ResponseEntity insertUser(@RequestBody User u) {
		if (us.storeUser(u)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}
	}

	@PutMapping
	public ResponseEntity<Boolean> updateUser(@RequestBody User u) {
		if (us.update(u))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
	}

	@DeleteMapping
	public ResponseEntity<Boolean> deleteUser(@RequestBody User u) {
		if (us.delete(u))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
	}
	
}
