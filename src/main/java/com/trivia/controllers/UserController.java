package com.trivia.controllers;

import com.trivia.models.Question;

@RestController
@RequestMapping(value="/user")
public class UserController {

	
	@GetMapping("/{id}")
	public ResponseEntity<User> getOneQuestion(@PathVariable("id") int id) {
																				
		Question q = dao.getById(id);
		if(a==null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 
		}
		return ResponseEntity.status(HttpStatus.OK).body(q);
	}
	
	
}
