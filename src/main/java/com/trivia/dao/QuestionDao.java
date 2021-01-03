package com.trivia.dao;

import com.trivia.models.Question;

public class QuestionDao {
	
	
	public static Question[] questions = {
			(new Question (1,"What is Baby Yoda's real name?","Grogu")),
			(new Question(2, "Who is Darth Vader's son?", "Luke"))
	};

	public Question getById(int id) {
		return questions[id];
	}
	public Question[] getAll(){
		return questions;
	}
}
