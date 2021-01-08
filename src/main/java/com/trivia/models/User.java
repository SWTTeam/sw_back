package com.trivia.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Component
@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	
	@Column(nullable=false, unique=true)
	private String username;
	@Column(nullable=false)
	private String password;
	
	@OneToMany(mappedBy = "scoreUser", fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Score> userScores = new ArrayList<>();	

	@OneToMany(mappedBy = "PersonRewardUser", fetch = FetchType.LAZY)
	@JsonBackReference//doesn't print this field when writing the JSON
	private List<PersonReward> userRewards = new ArrayList<>();
	
	@OneToOne(mappedBy = "showcaseUser", fetch = FetchType.EAGER)
	@JsonManagedReference
	
	private Showcase showcase;

	public User() {
		super();
	}

	public User(String username, String password, List<Score> userScores, List<PersonReward> userRewards,
			Showcase showcase) {
		super();
		this.username = username;
		this.password = password;
		this.userScores = userScores;
		this.userRewards = userRewards;
		this.showcase = showcase;
	}

	public User(int userId, String username, String password, List<Score> userScores, List<PersonReward> userRewards,
			Showcase showcase) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.userScores = userScores;
		this.userRewards = userRewards;
		this.showcase = showcase;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Score> getUserScores() {
		return userScores;
	}

	public void setUserScores(List<Score> userScores) {
		this.userScores = userScores;
	}

	public List<PersonReward> getUserRewards() {
		return userRewards;
	}

	public void setUserRewards(List<PersonReward> userRewards) {
		this.userRewards = userRewards;
	}

	public Showcase getShowcase() {
		return showcase;
	}

	public void setShowcase(Showcase showcase) {
		this.showcase = showcase;
	}

	@Override
	public int hashCode() {
		return Objects.hash(password, showcase, userId, userRewards, userScores, username);
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
		User other = (User) obj;
		return Objects.equals(password, other.password) && Objects.equals(showcase, other.showcase)
				&& userId == other.userId && Objects.equals(userRewards, other.userRewards)
				&& Objects.equals(userScores, other.userScores) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", userScores="
				+ userScores + ", userRewards=" + userRewards + ", showcase=" + showcase + "]";
	}	
}
	