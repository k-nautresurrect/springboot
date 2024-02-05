package com.exam.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.portal.entity.exam.Category;
import com.exam.portal.entity.exam.Quiz;
import com.exam.portal.service.CategoryService;
import com.exam.portal.service.QuizService;
@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizservice;

	@PostMapping("/")
	public Quiz addCategory(@RequestBody Quiz quiz) {
		quizservice.addQuiz(quiz);
		return quiz;
	}

	@DeleteMapping("/{qid}")
	public String deleteBook(@PathVariable long qid) {

		quizservice.deleteQuiz(qid);
		return "deleted";

	}

	@GetMapping("/")

	public List<Quiz> getCategories() {
		return quizservice.findAllQuizzes();

	}

	@PutMapping("/")
	public Quiz updateCategory(@RequestBody Quiz quiz) {
		quizservice.updateQuiz(quiz);
		return quiz;
	}

	@GetMapping("/{qid}")
	public Quiz getcategory(@PathVariable("qid") Long qid) {
		return this.quizservice.getQuiz(qid);
	}

}
