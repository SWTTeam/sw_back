package com.trivia.controllers;

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
	
	private PersonRewardService personRewardService;

	@Autowired
	public PersonRewardController(PersonRewardService personRewardService) {
		super();
		this.personRewardService = personRewardService;
	}
	

	@PostMapping
	public ResponseEntity insertPersonReward(@RequestBody PersonReward personReward) {
		
		if (personRewardService.insert(personReward)) {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}

}
