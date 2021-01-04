package com.trivia.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "scores")
public class Score {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="score_id")
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
