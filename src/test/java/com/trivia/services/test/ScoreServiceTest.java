package com.trivia.services.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import com.trivia.models.Score;
import com.trivia.services.ScoreService;

@SpringJUnitWebConfig(locations = {"/applicationContext.xml"})
public class ScoreServiceTest {

	private ScoreService scoreService;
	
	@Autowired
	public ScoreServiceTest(ScoreService scoreService) {
		super();
		this.scoreService = scoreService;
	}

	@Test
	void getByIdTest() {
		Score score = scoreService.getById(50);
		assertTrue(score.getScoreUser().getUserId()==25);
	}
	

	@Test
	void getAllTest() {
		List<Score> scores = scoreService.getAll();
		assertTrue(scores.size() != 0);
	}
}
