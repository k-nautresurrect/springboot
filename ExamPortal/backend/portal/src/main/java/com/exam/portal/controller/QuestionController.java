package com.exam.portal.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.portal.entity.exam.Question;
import com.exam.portal.entity.exam.Quiz;
import com.exam.portal.service.QuestionService;
import com.exam.portal.service.QuizService;


@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {
	@Autowired
	private QuestionService questionservice;
	@Autowired
	private QuizService quizservice;
	
	@PostMapping("/")
	public Question addQuestion(@RequestBody Question question) {
		questionservice.addQuestion(question);
		return question;
	}

	@DeleteMapping("/{quesid}")
	public String deleteBook(@PathVariable long quesid) {

		questionservice.deleteQuestion(quesid);
		return "deleted";

	}

	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQuestionsofquiz(@PathVariable("qid") Long qid) {
//		Quiz quiz =new Quiz();
//		quiz.setQid(qid);
//		Set<Question> quesofquiz= this.questionservice.getQuestionsofQuiz(quiz);
//		return ResponseEntity.ok(quesofquiz);
		Quiz quiz=this.quizservice.getQuiz(qid);
		Set<Question> questions=quiz.getQuestions();
		List list=new ArrayList(questions);
		if(list.size()>Integer.parseInt(quiz.getNumberofquestions())) {
			list=list.subList(0, Integer.parseInt(quiz.getNumberofquestions() +1));
		}
		Collections.shuffle(list);
		return ResponseEntity.ok(list);

	}

	@GetMapping("/quiz/all/{qid}")
	public ResponseEntity<?> getQuestionsofquizAdmin(@PathVariable("qid") Long qid) {
		Quiz quiz =new Quiz();
		quiz.setQid(qid);
		Set<Question> quesofquiz= this.questionservice.getQuestionsofQuiz(quiz);
		return ResponseEntity.ok(quesofquiz);
			
	}

	@PutMapping("/")
	public Question updateQuiz(@RequestBody Question question) {
		questionservice.updateQuestion(question);
		return question;
	}

	@GetMapping("/{quesid}")
	public Question getQuiz(@PathVariable("quesid") Long quesid) {
		return this.questionservice.getQuestion(quesid);
	}


}
