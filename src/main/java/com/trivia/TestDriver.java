package com.trivia;

//import java.io.IOException;
//import java.security.GeneralSecurityException;
//import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import com.trivia.models.User;
import com.trivia.repos.UserDAO;
import com.trivia.repos.UserDAOPostgres;
import com.trivia.services.UserService;
//import com.trivia.utilities.EncryptionUtility;

public class TestDriver {


	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory) ac.getBean("sessionFactory");
		UserDAO uDao = new UserDAOPostgres(sf);
		UserService uSer = new UserService(uDao);
//		try {
//			final EncryptionUtility eu = new EncryptionUtility();
//			List<User> uList = uDao.findAll();
//			for (User u2 : uList) {
//				String encryptPass = EncryptionUtility.encrypt(u2.getPassword(), eu.getKey());
//				uDao.update(new User(u2.getUserId(), u2.getUsername(), encryptPass, u2.getUserScores(), u2.getUserRewards(),
//						u2.getShowcase()));
//			}
//		} catch (GeneralSecurityException | IOException e) {
//			e.printStackTrace();
//		}
		
		System.out.println(uSer.getById(1).getUsername() + " " + uSer.getById(1).getPassword());
		
		((ClassPathXmlApplicationContext) ac).close();
	}
}
