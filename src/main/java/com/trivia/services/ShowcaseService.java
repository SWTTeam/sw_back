package com.trivia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trivia.models.Showcase;
import com.trivia.repos.ShowcaseDAO;

@Service
public class ShowcaseService {

	private ShowcaseDAO scDao;
	
	@Autowired
	public ShowcaseService(ShowcaseDAO scDao) {
		super();
		this.scDao = scDao;
	}

	public Showcase getById(int id) {
		return scDao.findById(id);
	}

	public List<Showcase> getAll() {		
		return scDao.findAll();
	}

	public boolean storeShowcase(Showcase sc) {
		scDao.insert(sc);
		if(scDao.findById(sc.getShowcaseId()).equals(sc))
			return true;
		return false;
	}

	public boolean update(Showcase sc) {
		scDao.update(sc);
		if(scDao.findById(sc.getShowcaseId()).equals(sc))
			return true;
		return false;
	}

	public boolean delete(Showcase sc) {
		scDao.delete(sc);
		if(!scDao.findById(sc.getShowcaseId()).equals(sc))
			return true;
		return false;
	}
}
