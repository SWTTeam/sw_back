package com.trivia.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.trivia.controllers.LoginController;

public class MasterServlet extends HttpServlet {
	
	private static final Logger log = LogManager.getLogger(MasterServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//info logs included to help track down erros for debugging
		log.info("in doGet");
		
		res.setContentType("application/json");
		res.setStatus(404);
		
		//Base of the url is removed to gain access to only the uri
		final String URI = req.getRequestURI().replace("/ec2-54-67-67-7.us-west-1.compute.amazonaws.com:8085/StarWarsTrivia/", "");
		
		
		LoginController loginController = new LoginController();
		
		switch (URI) {
			
			case "login": 
				
				try {
					loginController.login(req, res);
				} catch (IOException e) {
					e.printStackTrace();
					log.error("Runtime Error: ", e);
				} 
				
				break;
			
			case "trivia": 
				
				try {					
					ticketController.getUserTickets(req, res);
				} catch (IOException e) {
					e.printStackTrace();
					log.error("Runtime Error: ", e);
				}
				
				break;
			
			case "score": 

				try {
					ticketController.createTicket(req, res);
				} catch (IOException e) {
					e.printStackTrace();
					log.error("Runtime Error: ", e);
				}
				
				break;
			
			case "reward": 
				
				try {
					ticketController.getAllTickets(req, res);
				} catch (IOException e1) {
					e1.printStackTrace();
					log.error("Runtime Error: ", e1);
				}
					
					break;
			case "register":
				
				try {
					ticketController.sendReview(req, res);
				} catch (IOException e1) {
					e1.printStackTrace();
					log.error("Runtime Error: ", e1);;
				}
					
				break;
			
			case "logout": 
				
				try {
					signoutController.signout(req, res);
				} catch (IOException e) {
					e.printStackTrace();
					log.error("Runtime Error: ", e);
				}
				
				break;
			
			case "showcase":
				
				try {
					sessionController.checkSession(req, res);
				} catch (IOException e) {
					e.printStackTrace();
					log.error("Runtime Error: ", e);
				}
					
				break;
				
			default:
				
				break;
		}
	}
	
	//Non GET Http Requests are sent to the doGet for the sake of code simplicity and readability
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		log.info("in doPost");
		
		doGet(req, res);
		
	}
     
    public void doPatch(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
 
    	log.info("in doPatch");
    	
    	doGet(req, res);
		
    }

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (req.getMethod().equalsIgnoreCase("PATCH")){
           doPatch(req, res);
        } else {
            super.service(req, res);
        }
    } 

}
