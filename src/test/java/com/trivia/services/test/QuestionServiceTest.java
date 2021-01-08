package com.trivia.services.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import com.trivia.models.Question;
import com.trivia.services.QuestionService;

@SpringJUnitWebConfig(locations = {"/applicationContext.xml"})
public class QuestionServiceTest {

	private QuestionService questionService;

	@Autowired
	public QuestionServiceTest(QuestionService questionService) {
		super();
		this.questionService = questionService;
	}
	
	@Test
	void testGetById() {
		Question question = questionService.getById(1);
		assertTrue(question.getQuestion().equals("'s height measurement is? (***)"));
	}
	
	@Test
	void testGetAll() {
		List<Question> questions = questionService.getAll();
		assertTrue(questions.size() > 0);
	}
	
}
