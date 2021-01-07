package com.trivia.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/logout")
@CrossOrigin
public class LogoutController {
	
	@GetMapping
	public void logout(HttpSession httpSession) {
		
	httpSession.invalidate();
		
	}

}
