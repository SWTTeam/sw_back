package com.trivia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trivia.models.Question;
import com.trivia.repos.QuestionDAO;

@Service
public class QuestionService {

	private QuestionDAO qDao;
	
	@Autowired
	public QuestionService(QuestionDAO qDao) {
		super();
		this.qDao = qDao;
	}

	public Question getById(int id) {
		return qDao.findById(id);
	}

	public List<Question> getAll() {		
		return qDao.findAll();
	}

	public boolean storeQuestion(Question q) {
		qDao.insert(q);
		if(qDao.findById(q.getQuestionID()).equals(q))
			return true;
		return false;
	}

	public boolean update(Question q) {
		qDao.update(q);
		if(qDao.findById(q.getQuestionID()).equals(q))
			return true;
		return false;
	}

	public boolean delete(Question q) {
		qDao.delete(q);
		if(!qDao.findById(q.getQuestionID()).equals(q))
			return true;
		return false;
	}
}
