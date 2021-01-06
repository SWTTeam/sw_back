package com.trivia;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.hibernate.SessionFactory;

import com.trivia.models.User;
import com.trivia.repos.UserDAO;
import com.trivia.repos.UserDAOPostgres;
import com.trivia.utilities.EncryptionUtility;

public class TestDriver {
	private static SessionFactory sf;
	private static UserDAO uDao = new UserDAOPostgres(sf);
	
	
	public static void main(String[] args) {
		try {
			final EncryptionUtility eu = new EncryptionUtility();
			List<User> uList = uDao.findAll();
		for(User u2: uList) {
			String encryptPass = EncryptionUtility.encrypt(u2.getPassword(), eu.getKey());
			uDao.update(new User(u2.getUsername(), encryptPass, u2.getUserScores(), u2.getUserRewards(), u2.getShowcase()));
		}
		} catch (GeneralSecurityException | IOException e) {
			e.printStackTrace();
		}
	}
}
