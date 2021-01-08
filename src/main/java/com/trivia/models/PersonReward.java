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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="user_id", nullable=false)
	@JsonBackReference	
	private User PersonRewardUser;

	public PersonReward() {
		super();
	}

	public PersonReward(int personId, User personRewardUser) {
		super();
		this.personId = personId;
		PersonRewardUser = personRewardUser;
	}

	public PersonReward(int prNumber, int personId, User personRewardUser) {
		super();
		this.prNumber = prNumber;
		this.personId = personId;
		PersonRewardUser = personRewardUser;
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

	public User getPersonRewardUser() {
		return PersonRewardUser;
	}

	public void setPersonRewardUser(User personRewardUser) {
		PersonRewardUser = personRewardUser;
	}

	@Override
	public int hashCode() {
		return Objects.hash(PersonRewardUser, personId, prNumber);
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
		return Objects.equals(PersonRewardUser, other.PersonRewardUser) && personId == other.personId
				&& prNumber == other.prNumber;
	}

	@Override
	public String toString() {
		return "PersonReward [prNumber=" + prNumber + ", personId=" + personId + ", PersonRewardUser="
				+ PersonRewardUser + "]";
	}
}

