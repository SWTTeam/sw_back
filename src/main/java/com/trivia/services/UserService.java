package com.trivia.services;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trivia.controllers.LoginController;
import com.trivia.models.User;
import com.trivia.repos.UserDAO;
import com.trivia.utilities.EncryptionUtility;

@Service
public class UserService {
	
	private static final Logger log = LogManager.getLogger(UserService.class); 

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

	public User loginVer(User user) {
		
		log.info("in LoginVer(), about to enter findByUsername()");
		
		User userDB = uDao.findByUsername(user.getUsername());
		
		if (userDB != null) {
			try {
				
				log.info("userDB is not null");
				
				final EncryptionUtility encryptionUtility = new EncryptionUtility();
				String decryptPass = EncryptionUtility.decrypt(userDB.getPassword(), encryptionUtility.getKey());
				userDB.setPassword(decryptPass);
				
				log.info("About to try .equals");
				
				if (user.getUsername().equals(userDB.getUsername()) && user.getPassword().equals(userDB.getPassword())) {
					return userDB;
				}
			} catch (GeneralSecurityException | IOException e) {
				e.printStackTrace();
			}
		}
		
		log.info("userDB is null");
		
		return null;

	}
	
	public List<User> getAll() {
		return uDao.findAll();
	}

	public boolean storeUser(User u) {
		try {
			final EncryptionUtility eu = new EncryptionUtility();
			String encryptPass = EncryptionUtility.encrypt(u.getPassword(), eu.getKey());
			uDao.insert(new User(u.getUsername(), encryptPass, u.getUserScores(), u.getUserRewards(), u.getShowcase()));
		} catch (GeneralSecurityException | IOException e) {
			e.printStackTrace();
		}
		
		User testUser = uDao.findByUsername(u.getUsername());
		if (u.getUsername().equals(testUser.getUsername()))
			return true;
		return false;
		
//		try {
//			final EncryptionUtility eu = new EncryptionUtility();
//			User testUser = uDao.findByUsername(u.getUsername());
//			String decryptPass = EncryptionUtility.decrypt(testUser.getPassword(), eu.getKey());
//			if (u.)
//				return true;
//		} catch (GeneralSecurityException | IOException e) {
//			e.printStackTrace();
//		}
	}

	public boolean update(User u) {
		try {
			final EncryptionUtility eu = new EncryptionUtility();
			String encryptPass = EncryptionUtility.encrypt(u.getPassword(), eu.getKey());
			uDao.update(new User(u.getUsername(), encryptPass, u.getUserScores(), u.getUserRewards(), u.getShowcase()));
		} catch (GeneralSecurityException | IOException e) {
			e.printStackTrace();
		}
		if (uDao.findById(u.getUserId()).equals(u))
			return true;
		return false;
	}

	public boolean delete(User u) {
		uDao.delete(u);
		if (!uDao.findById(u.getUserId()).equals(u))
			return true;
		return false;
	}

}
