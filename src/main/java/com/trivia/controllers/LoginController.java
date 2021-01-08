package com.trivia.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trivia.models.User;
import com.trivia.models.UserDTO;
import com.trivia.services.UserService;

@Controller
public class LoginController {
	
	private static final Logger log = LogManager.getLogger(LoginController.class); 
	
	private ObjectMapper objectMapper = new ObjectMapper();

	private UserService userService;

	@Autowired
	public LoginController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	public LoginController() {
		super();
	}


	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		
		if (req.getMethod().equals("GET")) {
			
			final String URI = req.getRequestURI().replace("/ec2-54-67-67-7.us-west-1.compute.amazonaws.com:8085/StarWarsTrivia/login", "");
			
			if (URI.isEmpty()) {
	
				HttpSession httpSession = req.getSession();
				List<User> userList = userService.getAll();
				
				if (userList != null) {
					res.getWriter().print(userList);
					res.setStatus(200);
				}
				
				
			} else {
				
				int id = Integer.parseInt(URI);
				User user = userService.getById(id);
				
				if (user == null) {
					res.setStatus(204);		
				} else {
					res.getWriter().print(user);
					res.setStatus(200);
				}
				
				
			}
			
			
		} else if (req.getMethod().equals("POST")) {
			
			
			
			
			User foundUser = userService.loginVer(user);
			
			
			UserDTO userDTO = null;
			if (foundUser == null) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();	
			}else {
				
			
				
				userDTO = new UserDTO(foundUser.getUserId(), foundUser.getUsername());
				return ResponseEntity.status(HttpStatus.OK).body(userDTO);
			}
			
		} else if (req.getMethod().equals("PUT")) {
			
			BufferedReader bufferedReader = req.getReader();
			StringBuilder bodyBuilder = new StringBuilder();
			String line = bufferedReader.readLine();
			
			while (line != null)
			{
				bodyBuilder.append(line);
				line = bufferedReader.readLine();
			}
			
			String body = new String(bodyBuilder);
			
			User User = new User(body.userId, body.)
			
			
			if(userService.update(body)) {
				
			
				
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
			} else {
				
				
				
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
			}
			
			
		} else if (req.getMethod().equals("DELETE")) {
			
			if(userService.delete(user)) {
				
				
				
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
			} else {
				
				
				
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
			}
				
		}
		
		
		
	}
	
	
//	@GetMapping("/{id}")
//	public ResponseEntity<User> getOneUser(@PathVariable("id") int id) {
//		
////		log.info("in getOneUser(), about to enter userService.getId()");
////		
////		User user = userService.getById(id);
////		
////		log.info("leaving userService.getId(), back in getOneUser()");
////		
////		if (user == null) {
////			
////			log.info("user is null");
////			
////			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();		
////		} else {
////			
////			log.info("user is not null");
////			
////			return ResponseEntity.status(HttpStatus.OK).body(user);
////		}
//			
//		
//	}
//
//	@GetMapping
//	public ResponseEntity<List<User>> getUsers() {
//		
////		log.info("in getUsers(), about to return userService.getAll()");
////		
////		return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
//	}
//	
//	@PostMapping
//	public ResponseEntity<UserDTO> loginVerification(@RequestBody User user) {
////		
////		log.info("in loginVerification(), about to enter userService.loginVer()");
////		
////		User foundUser = userService.loginVer(user);
////		
////		log.info("leaving userService.loginVer(), back in loginVerification()");
////		
////		UserDTO userDTO = null;
////		if (foundUser == null) {
////			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();	
////		}else {
////			
////			log.info("foundUser is not null");
////			
////			userDTO = new UserDTO(foundUser.getUserId(), foundUser.getUsername());
////			return ResponseEntity.status(HttpStatus.OK).body(userDTO);
////		}
//	}
//	
////	@PostMapping
////	public ResponseEntity<Boolean> insertUser(@RequestBody User u) {
////		if(us.storeUser(u))
////			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
////		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
////	}
//	
//	@PutMapping
//	public ResponseEntity<Boolean> updateUser(@RequestBody User user) {
//		
////		log.info("in updateUser(), about to enter userService.update()");
////		
////		if(userService.update(user)) {
////			
////			log.info("leaving userService.update() with 'true', back in updateUser()");
////			
////			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
////		} else {
////			
////			log.info("leaving userService.update() with 'false', back in updateUser()");
////			
////			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
////		}
//			
//				
//	}
//	
//	@DeleteMapping
//	public ResponseEntity<Boolean> deleteUser(@RequestBody User user) {
//		
////		log.info("in deleteUser(), about to enter userService.delete()");
////		
////		if(userService.delete(user)) {
////			
////			log.info("leaving userService.delete() with 'true', back in deleteUser()");
////			
////			return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
////		} else {
////			
////			log.info("leaving userService.delete() with 'false', back in deleteUser()");
////			
////			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(false);
////		}
////			
//		
//	}
}
