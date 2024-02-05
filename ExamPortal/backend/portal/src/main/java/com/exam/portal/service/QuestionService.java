package com.exam.portal.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.portal.entity.exam.Question;
import com.exam.portal.entity.exam.Quiz;
import com.exam.portal.repo.QuestionRepository;
@Service
public class QuestionService {

	@Autowired
	private QuestionRepository quesrepo;

	public void addQuestion(Question question) {
		quesrepo.save(question);

	}

	public void deleteQuestion(Long id) {
		Question ques = quesrepo.getOne(id);
		quesrepo.delete(ques);

	}

	public List<Question> findAllQuestions() {
		List<Question> allQuestions = quesrepo.findAll();

		return allQuestions;
	}

	public void updateQuestion(Question question) {
		quesrepo.save(question);

	}

	public Question getQuestion(Long id) {

		return this.quesrepo.findById(id).get();

	}
	public Set<Question> getQuestionsofQuiz(Quiz quiz){
		return this.quesrepo.findByQuiz(quiz);
		
	}

}
