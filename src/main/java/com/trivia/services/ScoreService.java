package com.trivia.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trivia.models.Score;
import com.trivia.repos.ScoreDAO;

@Service
public class ScoreService {

	private ScoreDAO sDao;

	@Autowired
	public ScoreService(ScoreDAO sDao) {
		super();
		this.sDao = sDao;
	}

	public Score getById(int id) {
		return sDao.findById(id);
	}

	public List<Score> getAll() {
		List<Score> scoreList = sDao.findAll();
		Score temp = null;
		for (int i = 0; i < scoreList.size(); i++) {
			for (int j = i + 1; j < scoreList.size(); j++) {
				if (scoreList.get(i).getScore() > scoreList.get(j).getScore()) {
					temp = scoreList.get(i);
					scoreList.set(i, scoreList.get(j));
					scoreList.set(j, temp);
				}
			}
		}
		Collections.reverse(scoreList);
		return scoreList;
	}

	public boolean storeScore(Score s) {
		sDao.insert(s);
		if (sDao.findById(s.getScoreID()).equals(s))
			return true;
		return false;
	}

	public boolean update(Score s) {
		sDao.update(s);
		if (sDao.findById(s.getScoreID()).equals(s))
			return true;
		return false;
	}

	public boolean delete(Score s) {
		sDao.delete(s);
		if (!sDao.findById(s.getScoreID()).equals(s))
			return true;
		return false;
	}
}
