package com.trivia.services.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import com.trivia.models.PersonReward;
import com.trivia.services.PersonRewardService;

@SpringJUnitWebConfig(locations = {"/applicationContext.xml"})
public class PersonRewardServiceTest {

	private PersonRewardService reward;

	@Autowired
	public PersonRewardServiceTest(PersonRewardService reward) {
		super();
		this.reward = reward;
	}
	
	
	@Test
	void testFindById() {
		PersonReward personReward = reward.findById(1);
		int id = personReward.getPersonId();
		assertTrue(57==id);
	}
	
	@Test
	void testFindAll() {
		List<PersonReward> people = reward.findAll();
		assertTrue(people.size() > 0);
	}
}
