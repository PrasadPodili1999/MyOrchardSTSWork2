package com.mt.onetomanydemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mt.onetomanydemo.exceptionhandler.QuestionNotFoundException;
import com.mt.onetomanydemo.model.Question;

@Service
public interface QuestionService {

	public Question addQuestion(Question question);
	public Optional<Question> getQuestionById(int id) throws QuestionNotFoundException;
	public List<Question> getAllQuestions();
	public Question updateQuestion(Question question);
	public void deleteQuestionById(int id) throws QuestionNotFoundException;
	public void deleteAllQuestions() throws QuestionNotFoundException;
}
