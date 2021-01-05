package com.trivia.repos;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trivia.models.Score;

@Repository
@Transactional
public class ScoreDAOPostgres implements ScoreDAO{

	private SessionFactory sf;

	@Autowired
	public ScoreDAOPostgres(SessionFactory sf) {
		super();
		this.sf = sf;
	}
	
	@Override
	public Score findById(int id) {
		Session s = sf.getCurrentSession();
		return s.get(Score.class, id);
	}

	@Override
	public List<Score> findAll() {
		Session s = sf.getCurrentSession();
		CriteriaQuery<Score> cq = s.getCriteriaBuilder().createQuery(Score.class);
		cq.from(Score.class);
		return s.createQuery(cq).getResultList();
	}

	@Override
	public void insert(Score s) {
		Session ses = sf.getCurrentSession();
		ses.saveOrUpdate(s);
	}

	@Override
	public void update(Score s) {
		Session ses = sf.getCurrentSession();
		ses.update(s);
	}

	@Override
	public void delete(Score s) {
		Session ses = sf.getCurrentSession();
		ses.delete(s);
	}
}
