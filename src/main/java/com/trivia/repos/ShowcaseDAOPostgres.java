package com.trivia.repos;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trivia.models.Showcase;

@Repository
@Transactional
public class ShowcaseDAOPostgres implements ShowcaseDAO{

	private SessionFactory sf;

	@Autowired
	public ShowcaseDAOPostgres(SessionFactory sf) {
		super();
		this.sf = sf;
	}
	
	@Override
	public Showcase findById(int id) {
		Session s = sf.getCurrentSession();
		return s.get(Showcase.class, id);
	}

	@Override
	public List<Showcase> findAll() {
		Session s = sf.getCurrentSession();
		CriteriaQuery<Showcase> cq = s.getCriteriaBuilder().createQuery(Showcase.class);
		cq.from(Showcase.class);
		return s.createQuery(cq).getResultList();
	}

	@Override
	public void insert(Showcase sc) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(sc);
	}

	@Override
	public void update(Showcase sc) {
		Session s = sf.getCurrentSession();
		s.update(sc);
	}

	@Override
	public void delete(Showcase sc) {
		Session s = sf.getCurrentSession();
		s.delete(sc);
	}
}
