package com.trivia.services.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertNull;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trivia.models.PersonReward;
import com.trivia.models.Score;
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
	
	@Test
	void loginVerTest() {
		List<Score> scores = new ArrayList<>();
		List<PersonReward> rewards = new ArrayList<>();
		User user = new User("skytsar", "password", scores, rewards, null);
		assertNotNull(user);
	}
	
	@Test
	void getAllTest() {
		assertTrue(userService.getAll().size() != 0);
	}
	
//	@Test
//	void updateTest() {
//		List<Score> scores = new ArrayList<>();
//		List<PersonReward> rewards = new ArrayList<>();
//		User user = new User("test", "password55", scores, rewards, null);
//		assertTrue(userService.update(user));
//	}
}
