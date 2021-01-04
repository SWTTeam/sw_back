package com.trivia.models;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "scores")
public class Score {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="score_id")
	private int scoreID;	
	
	@Column
	private int score;
	@Column
	private Date generation;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;

	public Score() {
		super();
	}

	public Score(int score, Date generation, User user) {
		super();
		this.score = score;
		this.generation = generation;
		this.user = user;
	}

	public Score(int scoreID, int score, Date generation, User user) {
		super();
		this.scoreID = scoreID;
		this.score = score;
		this.generation = generation;
		this.user = user;
	}

	public int getScoreID() {
		return scoreID;
	}

	public void setScoreID(int scoreID) {
		this.scoreID = scoreID;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getGeneration() {
		return generation;
	}

	public void setGeneration(Date generation) {
		this.generation = generation;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(generation, score, scoreID, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Score other = (Score) obj;
		return Objects.equals(generation, other.generation) && score == other.score && scoreID == other.scoreID
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Score [scoreID=" + scoreID + ", score=" + score + ", generation=" + generation + ", user=" + user + "]";
	}	
}
