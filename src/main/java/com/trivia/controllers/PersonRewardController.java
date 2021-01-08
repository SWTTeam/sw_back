package com.trivia.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trivia.models.PersonReward;
import com.trivia.services.PersonRewardService;

@RestController
@RequestMapping(value = "/reward")
@CrossOrigin
public class PersonRewardController {
	
	private static final Logger log = LogManager.getLogger(PersonRewardController.class); 
	
	private PersonRewardService personRewardService;

	@Autowired
	public PersonRewardController(PersonRewardService personRewardService) {
		super();
		this.personRewardService = personRewardService;
	}
	

	@PostMapping
	public ResponseEntity insertPersonReward(@RequestBody PersonReward personReward) {
		
		log.info("in insertPersonReward(), about to enter personRewardService.insert()");
		
		if (personRewardService.insert(personReward)) {
			
			log.info("leaving personRewardService.insert() with 'true");
			
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} else {
			
			log.info("leaving personRewardService.insert() with 'false");
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}

}
