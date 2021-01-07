package com.trivia.services.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trivia.models.User;
import com.trivia.services.UserService;
import com.trivia.utilities.EncryptionUtility;

public class UserServiceTest {

	private static UserService userService;
	
	public UserServiceTest() {
	}
	
	@BeforeAll
	static void setUpEnviron() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		userService = context.getBean(UserService.class);
	}

	@Test
	void getByIdTest() {
		User storedUser = userService.getById(2);
		try {
			EncryptionUtility encryptionUtility = new EncryptionUtility();
			String decryptPassword = EncryptionUtility.decrypt(storedUser.getPassword(), encryptionUtility.getKey());
			assertTrue(storedUser.getUsername().equals("logriffith") && decryptPassword.equals("password"));
		} catch (GeneralSecurityException | IOException e) {
			e.getMessage();
		}
	}
	
	@Test
	void getByNameTest() {
		assertNotNull(userService.getByName("bntufte"));
	}
	
//	@Test
//	void getByNameTestNull() {
//		assertNull(userService.getByName("bntufte22"));
//	}
}
