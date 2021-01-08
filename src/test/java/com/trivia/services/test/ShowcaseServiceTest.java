package com.trivia.services.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import com.trivia.models.Showcase;
import com.trivia.models.User;
import com.trivia.services.ShowcaseService;
import com.trivia.services.UserService;

@SpringJUnitWebConfig(locations = {"/applicationContext.xml"})
class ShowcaseServiceTest {	

	private ShowcaseService ss;
	private UserService us;
	
	@Autowired
	public ShowcaseServiceTest(ShowcaseService ss, UserService us) {
		super();
		this.ss = ss;
		this.us = us;
	}

	@Test
	void testGetById() {
		assertEquals(35, ss.getById(1).getPeople4());
	}

	@Test
	void testGetAll() {
		assertTrue(!ss.getAll().isEmpty());
	}
	
	@Test
	void testStoreShowcase() {
		us.storeUser(new User("jak","hank",null,null,null));
		assertTrue(ss.storeShowcase(new Showcase(1,1,1,1,new User(26,"jak","hill",null,null,null))));
	}
	
	@Test
	void testUpdate() {
		Showcase test = new Showcase(1,0,0,0,0,us.getById(1));
		assertTrue(ss.update(test));
	}
	
	@Test
	void testDelete() {
		Showcase test = new Showcase(2,8,24,5,31,us.getById(2));
		assertTrue(ss.delete(test));
	}
}
