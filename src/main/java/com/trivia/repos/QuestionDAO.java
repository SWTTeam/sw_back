package com.trivia.repos;

import java.util.List;

import com.trivia.models.Question;

public interface QuestionDAO {

	public Question findById(int id);

	public List<Question> findAll();

	public void insert(Question q);

	public void delete(Question q);

	public void update(Question q);
}
