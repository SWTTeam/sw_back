package com.trivia.repos;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.trivia.models.User;
import com.trivia.services.UserService;

@Repository
@Transactional
@EnableTransactionManagement
public class UserDAOPostgres implements UserDAO {
	
	private static final Logger log = LogManager.getLogger(UserDAOPostgres.class);

	private SessionFactory sf;

	@Autowired
	public UserDAOPostgres(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	@Override
	public User findById(int id) {
		Session s;
		try {
		    s = sf.getCurrentSession();
		} catch (HibernateException e) {
		    s = sf.openSession();
		    User u = s.get(User.class, id);		    
			s.close();
			return u;
		}
//		Session s = sf.getCurrentSession();
		return s.get(User.class, id);
	}

	@Override
	public User findByUsername(String name) {
		
		log.info("in findByUsername(), about to enter sf.getCurrentSession()");
		
		@SuppressWarnings("deprecation")
		Criteria crit = sf.getCurrentSession().createCriteria(User.class);
		
		log.info("about to enter crit.add");
		
		crit.add(Restrictions.eq("username", name));
		//System.out.println((User) crit.list().get(0));
		
		log.info("about to enter crit.list()");
		return (User) crit.list().get(0);
	}

	@Override
	public List<User> findAll() {
		Session s;
		try {
		    s = sf.getCurrentSession();
		} catch (HibernateException e) {
		    s = sf.openSession();
		    List<User> ulist;
		    CriteriaQuery<User> cq = s.getCriteriaBuilder().createQuery(User.class);
			cq.from(User.class);
			ulist = s.createQuery(cq).getResultList();
			s.close();
			return ulist;
		}
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
		Session s;
		try {
		    s = sf.getCurrentSession();
		} catch (HibernateException e) {
		    s = sf.openSession();
		    s.beginTransaction();
		    s.update(u);
		    s.getTransaction().commit();
		    s.close();
		    return;
		}
		s.update(u);
	}

	@Override
	public void delete(User u) {
		Session s = sf.getCurrentSession();
		s.delete(u);
	}
	
	
}
