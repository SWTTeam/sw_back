package com.trivia.repos;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trivia.models.PersonReward;

@Repository
@Transactional
public class PersonRewardDAOPostgres implements PersonRewardDAO {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public PersonRewardDAOPostgres(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public PersonReward findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(PersonReward.class, id);
	}

	@Override
	public List<PersonReward> findAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaQuery<PersonReward> criteriaQuery = session.getCriteriaBuilder().createQuery(PersonReward.class);
		criteriaQuery.from(PersonReward.class);
		return session.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public int insert(PersonReward reward) {
		Session session = sessionFactory.getCurrentSession();
		return (int) session.save(reward);
		
	}

	@Override
	public void delete(PersonReward reward) {
		Session session = sessionFactory.getCurrentSession();
		session.update(reward);
	}

	@Override
	public void update(PersonReward reward) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(reward);
	}

}
