package com.mt.onetomanydemo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.onetomanydemo.exceptionhandler.QuestionNotFoundException;
import com.mt.onetomanydemo.model.Question;
import com.mt.onetomanydemo.repository.QuestionRepository;
import com.mt.onetomanydemo.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	QuestionRepository questionRepo;
	
	@Override
	public Question addQuestion(Question question)
	{
		return questionRepo.save(question);
	}
	
	@Override
	public Optional<Question> getQuestionById(int id) throws QuestionNotFoundException
	{
		Optional<Question> que=questionRepo.findById(id);
		if(que.isEmpty())
		{
			throw new QuestionNotFoundException();
		}
		else
		{
			return que;
		}		
	}
	@Override
	public List<Question> getAllQuestions()
	{
		List<Question> questionList=new ArrayList<Question>();
		Iterable<Question> itr=questionRepo.findAll();
		for(Question question:itr)
		{
			questionList.add(question);
		}
		ArrayList<Question> al=(ArrayList<Question>)questionList.stream().map(m->m).collect(Collectors.toList());
		return questionList;
	}
	@Override
	public Question updateQuestion(Question question)
	{
		return questionRepo.save(question);
	}
	@Override
	public void deleteQuestionById(int id) throws QuestionNotFoundException
	{
		if(getQuestionById(id).isPresent())
		{
			questionRepo.deleteById(id);
		}
		else
		{
			throw new QuestionNotFoundException();
		}
		
	}

	@Override
	public void deleteAllQuestions() throws QuestionNotFoundException
	{
		if(!getAllQuestions().isEmpty())
		{
			questionRepo.deleteAll();
		}
		else
		{
			throw new QuestionNotFoundException();
		}
		
		
	}
}
