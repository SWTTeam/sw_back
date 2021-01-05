package com.trivia.repos;

import java.util.List;

import com.trivia.models.User;

public interface UserDAO {
	
	public User findById(int id);	
	public User findByUsername(String name);	
	public List<User> findAll();	
	public void insert(User u);	
	public void update(User u);
	public void delete(User u);
}
