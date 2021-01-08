package com.trivia.controllers;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/logout")
@CrossOrigin
public class LogoutController {
	
	private static final Logger log = LogManager.getLogger(LogoutController.class);
	
	@GetMapping
	public void logout(HttpSession httpSession) {
		
		log.info("in logout()");
		
		httpSession.invalidate();
		
		log.info("Session invalidated");
		
	}

}
