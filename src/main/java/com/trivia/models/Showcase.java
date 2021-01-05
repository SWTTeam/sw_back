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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "showcases")
public class Showcase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="showcase_id")
	private int showcaseId;
	
	@Column
	private int people1;
	@Column
	private int people2;
	@Column
	private int people3;
	@Column
	private int people4;
	
	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="user_id"/*, nullable=false, unique=true*/)
	private User user;

	public Showcase() {
		super();
	}

	public Showcase(int people1, int people2, int people3, int people4, User user) {
		super();
		this.people1 = people1;
		this.people2 = people2;
		this.people3 = people3;
		this.people4 = people4;
		this.user = user;
	}

	public Showcase(int showcaseId, int people1, int people2, int people3, int people4, User user) {
		super();
		this.showcaseId = showcaseId;
		this.people1 = people1;
		this.people2 = people2;
		this.people3 = people3;
		this.people4 = people4;
		this.user = user;
	}

	public int getShowcaseId() {
		return showcaseId;
	}

	public void setShowcaseId(int showcaseId) {
		this.showcaseId = showcaseId;
	}

	public int getPeople1() {
		return people1;
	}

	public void setPeople1(int people1) {
		this.people1 = people1;
	}

	public int getPeople2() {
		return people2;
	}

	public void setPeople2(int people2) {
		this.people2 = people2;
	}

	public int getPeople3() {
		return people3;
	}

	public void setPeople3(int people3) {
		this.people3 = people3;
	}

	public int getPeople4() {
		return people4;
	}

	public void setPeople4(int people4) {
		this.people4 = people4;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(people1, people2, people3, people4, showcaseId, user);
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
		Showcase other = (Showcase) obj;
		return people1 == other.people1 && people2 == other.people2 && people3 == other.people3
				&& people4 == other.people4 && showcaseId == other.showcaseId && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Showcase [showcaseId=" + showcaseId + ", people1=" + people1 + ", people2=" + people2 + ", people3="
				+ people3 + ", people4=" + people4 + ", user=" + user + "]";
	}
}
