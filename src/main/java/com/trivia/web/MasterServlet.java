package com.trivia.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MasterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	//comment
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//A print writer created from the response will write to that response object. We can use this to write HTML directly
		PrintWriter pw = res.getWriter();
		pw.print("<h1>Hello from your doGet method from Jenkins! Star Wars Trivia pipeline is a SUCCESS!</h1>");
		res.setStatus(202);
	}

}
