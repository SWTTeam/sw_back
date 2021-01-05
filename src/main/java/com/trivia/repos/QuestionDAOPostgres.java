package com.trivia.repos;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trivia.models.Question;

@Repository
@Transactional
public class QuestionDAOPostgres implements QuestionDAO {
	
	private SessionFactory sf;

	@Autowired
	public QuestionDAOPostgres(SessionFactory sf) {
		super();
		this.sf = sf;
	}
	
	@Override
	public Question findById(int id) {
		Session s = sf.getCurrentSession();
		return s.get(Question.class, id);
	}

	@Override
	public List<Question> findAll() {
		Session s = sf.getCurrentSession();
		CriteriaQuery<Question> cq = s.getCriteriaBuilder().createQuery(Question.class);
		cq.from(Question.class);
		return s.createQuery(cq).getResultList();
	}

	@Override
	public void insert(Question q) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(q);
	}

	@Override
	public void update(Question q) {
		Session s = sf.getCurrentSession();
		s.update(q);
	}

	@Override
	public void delete(Question q) {
		Session s = sf.getCurrentSession();
		s.delete(q);
	}
}
