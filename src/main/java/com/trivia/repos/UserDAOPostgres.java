package com.trivia.repos;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trivia.models.User;

@Repository
@Transactional
public class UserDAOPostgres implements UserDAO {

	private SessionFactory sf;

	@Autowired
	public UserDAOPostgres(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	@Override
	public User findById(int id) {
		Session s = sf.getCurrentSession();
		return s.get(User.class, id);
	}

	@Override
	public User findByUsername(String name) {
		@SuppressWarnings("deprecation")
		Criteria crit = sf.getCurrentSession().createCriteria(User.class);
		crit.add(Restrictions.eq("username", name));
		return (User) crit.list().get(0);
	}

	@Override
	public List<User> findAll() {
		Session s = sf.getCurrentSession();
		CriteriaQuery<User> cq = s.getCriteriaBuilder().createQuery(User.class);
		cq.from(User.class);
		return s.createQuery(cq).getResultList();
	}

	@Override
	public void insert(User u) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(u);
	}

	@Override
	public void update(User u) {
		Session s = sf.getCurrentSession();
		s.update(u);
	}

	@Override
	public void delete(User u) {
		Session s = sf.getCurrentSession();
		s.delete(u);
	}
	
	
}
