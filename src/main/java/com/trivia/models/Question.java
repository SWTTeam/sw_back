package com.trivia.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "questions")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="question_id")
	private int questionID;
	
	@Column(nullable=false, unique=true)
	private String question;
	
	public Question() {
		super();
	}

	public Question(String question) {
		super();
		this.question = question;
	}

	public Question(int questionID, String question) {
		super();
		this.questionID = questionID;
		this.question = question;
	}

	public int getQuestionID() {
		return questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public int hashCode() {
		return Objects.hash(question, questionID);
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
		Question other = (Question) obj;
		return Objects.equals(question, other.question) && questionID == other.questionID;
	}

	@Override
	public String toString() {
		return "Question [questionID=" + questionID + ", question=" + question + "]";
	}	
}
