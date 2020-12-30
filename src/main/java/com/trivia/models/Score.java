package com.trivia.models;

import java.sql.Date;

public class Score {
	
	private int scoreID;
	private int userID;
	private int score;
	private Date genration;
	
	
	
	public Date getGenration() {
		return genration;
	}
	public void setGenration(Date genration) {
		this.genration = genration;
	}
	public int getScoreID() {
		return scoreID;
	}
	public void setScoreID(int scoreID) {
		this.scoreID = scoreID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Score(int userID, int score, Date genration) {
		super();
		this.userID = userID;
		this.score = score;
		this.genration = genration;
	}
	public Score(int scoreID, int userID, int score, Date genration) {
		super();
		this.scoreID = scoreID;
		this.userID = userID;
		this.score = score;
		this.genration = genration;
	}
	
	

}
