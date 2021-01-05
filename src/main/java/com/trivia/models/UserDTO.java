package com.trivia.models;

public class UserDTO {
	
	public int userId;
	public String username;

	public UserDTO() {
		super();
	}

	public UserDTO(int userId, String username) {
		super();
		this.userId = userId;
		this.username = username;
	}
	
}
