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
import org.springframework.web.bind.annotation.RestController;

import com.trivia.models.User;
import com.trivia.models.UserDTO;
import com.trivia.services.UserService;

@RestController
@RequestMapping(value="/login")
@CrossOrigin
public class LoginController {

	private UserService userService;

	@Autowired
	public LoginController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getOneUser(@PathVariable("id") int id) {
		User user = userService.getById(id);
		if (user == null)
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();		
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

	@GetMapping
	public ResponseEntity<List<User>> getUsers() {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> loginVerification(@RequestBody User user) {
		User foundUser = userService.loginVer(user);
		UserDTO userDTO = null;
		if (foundUser == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();	
		}else {
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
		if(userService.update(user))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);		
	}
	
	@DeleteMapping
	public ResponseEntity<Boolean> deleteUser(@RequestBody User user) {
		if(userService.delete(user))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
	}
}
