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
import com.trivia.models.UserDTO;
import com.trivia.services.UserService;

@RestController
@RequestMapping(value="/login")
@CrossOrigin
public class LoginController {
	
	private static final Logger log = LogManager.getLogger(LoginController.class); 

	private UserService userService;

	@Autowired
	public LoginController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getOneUser(@PathVariable("id") int id) {
		
		log.info("in getOneUser(), about to enter userService.getId()");
		
		User user = userService.getById(id);
		
		log.info("leaving userService.getId(), back in getOneUser()");
		
		if (user == null) {
			
			log.info("user is null");
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();		
		} else {
			
			log.info("user is not null");
			
			return ResponseEntity.status(HttpStatus.OK).body(user);
		}
			
		
	}

	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		
		log.info("in getUsers(), about to return userService.getAll()");
		
		return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> loginVerification(@RequestBody User user) {
		
		log.info("in loginVerification(), about to enter userService.loginVer()");
		
		User foundUser = userService.loginVer(user);
		
		log.info("leaving userService.loginVer(), back in loginVerification()");
		UserDTO userDTO = null;
		if (foundUser == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();	
		}else {
			
			log.info("foundUser is not null");
			
			userDTO = new UserDTO(foundUser.getUserId(), foundUser.getUsername());
			return ResponseEntity.status(HttpStatus.OK).body(userDTO);
		}
	}
	
//	@PostMapping
//	public ResponseEntity<Boolean> insertUser(@RequestBody User u) {
//		if(us.storeUser(u))
//			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
//		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
//	}
	
	@PutMapping("/update")
	public ResponseEntity<Boolean> updateUser(@RequestBody User user) {
		
		log.info("in updateUser(), about to enter userService.update()");
		
		if(userService.update(user)) {
			
			log.info("leaving userService.update() with 'true', back in updateUser()");
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
		} else {
			
			log.info("leaving userService.update() with 'false', back in updateUser()");
			
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
		}
			
				
	}
	
	@DeleteMapping
	public ResponseEntity<Boolean> deleteUser(@RequestBody User user) {
		
		log.info("in deleteUser(), about to enter userService.delete()");
		
		if(userService.delete(user)) {
			
			log.info("leaving userService.delete() with 'true', back in deleteUser()");
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
		} else {
			
			log.info("leaving userService.delete() with 'false', back in deleteUser()");
			
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
		}
			
		
	}
}
