package com.trivia.models;

public class Question {

	private int questionID;
	private String question;
	private String answer;
	
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
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Question(int questionID, String question, String answer) {
		super();
		this.questionID = questionID;
		this.question = question;
		this.answer = answer;
	}
	public Question(String question, String answer) {
		super();
		this.question = question;
		this.answer = answer;
	}
	
	
	
	
}
