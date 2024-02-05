package com.exam.portal.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.portal.entity.exam.Question;
import com.exam.portal.entity.exam.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Long>{

	Set<Question> findByQuiz(Quiz quiz);

}
