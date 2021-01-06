package com.trivia.services.test;

import java.io.IOException;
import java.security.GeneralSecurityException;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.trivia.models.User;
import com.trivia.repos.UserDAO;
import com.trivia.services.UserService;
import com.trivia.utilities.EncryptionUtility;

public class UserServiceTest {

	public static UserService userService;
	public static UserDAO userDAO;
	
	@BeforeAll
	public static void setUpUserService() {
		userService = new UserService(userDAO);
	}
	
	@Test
	void getByIdTest(int id) {
		User storedUser = userService.getById(2);
		try {
			EncryptionUtility encryptionUtility = new EncryptionUtility();
			String decryptPassword = EncryptionUtility.decrypt(storedUser.getPassword(), encryptionUtility.getKey());
			assertTrue(storedUser.getUsername().equals("logriffith") && decryptPassword.equals("password"));
		} catch (GeneralSecurityException | IOException e) {
			e.getMessage();
		}
	}
}
