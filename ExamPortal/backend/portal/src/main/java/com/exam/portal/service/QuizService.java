package com.exam.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.portal.entity.exam.Quiz;
import com.exam.portal.repo.QuizRepository;


@Service
public class QuizService {
	@Autowired
	private QuizRepository quizrepo;
	
	public void addQuiz(Quiz quiz) {
		quizrepo.save(quiz);

	}

	public void deleteQuiz(Long id) {
		this.quizrepo.deleteById(id);
	

	}

	public List<Quiz> findAllQuizzes() {
		List<Quiz> allQuizzes = quizrepo.findAll();

		return allQuizzes;
	}

	public void updateQuiz(Quiz quiz) {
		quizrepo.save(quiz);

	}
	public Quiz getQuiz(Long id) {
		
		return this.quizrepo.findById(id).get();
		
	}

}
