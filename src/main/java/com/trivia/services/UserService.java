package com.trivia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trivia.models.User;
import com.trivia.repos.UserDAO;

@Service
public class UserService {

	private UserDAO uDao;
	
	@Autowired
	public UserService(UserDAO uDao) {
		super();
		this.uDao = uDao;
	}
	
	public User getById(int id) {
		return uDao.findById(id);
	}
	
	public User getByName(String name) {
		return uDao.findByUsername(name);
	}
	
	public User loginVer(User u) {
		User userVer = uDao.findByUsername(u.getUsername());
		if(u.getPassword().equals(userVer.getPassword()))
			return userVer;
		return null;
	}	

	public List<User> getAll() {		
		return uDao.findAll();
	}

	public boolean storeUser(User u) {
		uDao.insert(u);
		if(uDao.findById(u.getUserId()).equals(u))
			return true;
		return false;
	}

	public boolean update(User u) {
		uDao.update(u);
		if(uDao.findById(u.getUserId()).equals(u))
			return true;
		return false;
	}

	public boolean delete(User u) {
		uDao.delete(u);
		if(!uDao.findById(u.getUserId()).equals(u))
			return true;
		return false;
	}	
}
