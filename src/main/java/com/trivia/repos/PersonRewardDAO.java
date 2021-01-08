package com.trivia.repos;

import java.util.List;

import com.trivia.models.PersonReward;

public interface PersonRewardDAO {
	
	public PersonReward findById(int id);
	
	public List<PersonReward> findAll();
	
	public int insert(PersonReward reward);
	
	public void delete(PersonReward reward);
	
	public void update(PersonReward reward);

}
