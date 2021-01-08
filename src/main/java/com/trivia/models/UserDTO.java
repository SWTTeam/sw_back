package com.trivia.models;

import java.util.List;

public class UserDTO {
	
	public int userId;
	public String username;
	public String password;
	public List<Score> userScores;
	public List<PersonReward> userRewards;
	public Showcase showcase;

	public UserDTO() {
		super();
	}

	public UserDTO(int userId, String username, String password, List<Score> userScores, List<PersonReward> userRewards,
			Showcase showcase) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.userScores = userScores;
		this.userRewards = userRewards;
		this.showcase = showcase;
	}


	
}
