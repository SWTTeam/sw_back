package com.trivia.repos;

import java.util.List;

import com.trivia.models.Showcase;

public interface ShowcaseDAO {
	
	public Showcase findById(int id);
	public List<Showcase> findAll();
	public void insert(Showcase sc);
	public void update(Showcase sc);
	public void delete(Showcase sc);
}
