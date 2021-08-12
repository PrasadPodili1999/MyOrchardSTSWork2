package com.mt.onetomanydemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mt.onetomanydemo.exceptionhandler.QuestionNotFoundException;
import com.mt.onetomanydemo.model.Question;
import com.mt.onetomanydemo.service.QuestionService;
import com.mt.onetomanydemo.service.impl.QuestionServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/QA")
public class QuestionController {

	@Autowired
	QuestionService questionService;
	
	@RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
	public ResponseEntity<Question> addQuestion(@RequestBody Question question)
	{
		 Question ques=questionService.addQuestion(question);
		 return ResponseEntity.status(HttpStatus.CREATED).body(ques);
	}
	
	@RequestMapping(value = "/getQuestion/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Question>> getQuestionById(@PathVariable("id") int id) throws QuestionNotFoundException
	{
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(questionService.getQuestionById(id));
		}
		catch(Exception e)
		{
			log.error("question was not found "+e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	
	@RequestMapping(value = "/getQuestion", method = RequestMethod.GET)
	public ResponseEntity<List<Question>> getAllQuestions()
	{
		return ResponseEntity.status(HttpStatus.OK).body(questionService.getAllQuestions());
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question)
	{
		return ResponseEntity.status(HttpStatus.OK).body(questionService.updateQuestion(question));
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteQuestionById(@PathVariable("id") int id)
	{
		try
		{
			questionService.deleteQuestionById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch(Exception e)
		{
			log.error("question was not found "+e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
		
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAllQuestions()
	{
		try
		{
			questionService.deleteAllQuestions();
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch(Exception e)
		{
			log.error("question was not found "+e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
