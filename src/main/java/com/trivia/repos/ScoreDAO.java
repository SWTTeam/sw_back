package com.trivia.repos;

import java.util.List;

import com.trivia.models.Score;

public interface ScoreDAO {
	
	public Score findById(int id);
	public List<Score> findAll();
	public void insert(Score s);
	public void update(Score s);	
	public void delete(Score s);
}
