package com.mt.onetomanydemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mt.onetomanydemo.model.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer>{

}
