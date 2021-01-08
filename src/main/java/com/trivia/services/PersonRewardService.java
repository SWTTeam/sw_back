package com.trivia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trivia.models.PersonReward;
import com.trivia.repos.PersonRewardDAO;

@Service
public class PersonRewardService {

	private PersonRewardDAO personRewardDAO;

	@Autowired
	public PersonRewardService(PersonRewardDAO personRewardDAO) {
		super();
		this.personRewardDAO = personRewardDAO;
	}
	
	public PersonReward findById(int id) {
		return personRewardDAO.findById(id);
	}
	
	public List<PersonReward> findAll(){
		return personRewardDAO.findAll();
	}
	
	public boolean insert(PersonReward reward) {
		int id = personRewardDAO.insert(reward);
		
		if(personRewardDAO.findById(id).getPersonId() == reward.getPersonId()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean delete(PersonReward reward) {
		personRewardDAO.delete(reward);
		if(personRewardDAO.findById(reward.getPersonId()) == null) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean update(PersonReward reward) {
		personRewardDAO.update(reward);
		if(personRewardDAO.findById(reward.getPersonId()).equals(reward)) {
			return true;
		}else {
			return false;
		}
	}
}
