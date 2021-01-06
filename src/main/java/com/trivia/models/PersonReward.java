package com.trivia.models;

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

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "person_reward")
public class PersonReward {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="person_reward_id")
	private int prNumber;
	
	@Column(nullable=false)
	private int personId;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="user_id", nullable=false)
	private User user;

	public PersonReward() {
		super();
	}

	public PersonReward(int personId, User user) {
		super();
		this.personId = personId;
		this.user = user;
	}

	public PersonReward(int prNumber, int personId, User user) {
		super();
		this.prNumber = prNumber;
		this.personId = personId;
		this.user = user;
	}

	public int getPrNumber() {
		return prNumber;
	}

	public void setPrNumber(int prNumber) {
		this.prNumber = prNumber;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(personId, prNumber, user);
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
		PersonReward other = (PersonReward) obj;
		return personId == other.personId && prNumber == other.prNumber && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "PersonReward [prNumber=" + prNumber + ", personId=" + personId + ", user=" + user + "]";
	}	
}

