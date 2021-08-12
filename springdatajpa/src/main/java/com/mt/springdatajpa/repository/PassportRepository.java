package com.mt.springdatajpa.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mt.springdatajpa.entity.Passport;
import com.mt.springdatajpa.entity.Student;

@Repository
public interface PassportRepository extends CrudRepository<Passport, Integer>
{
	@Query("select s from Student s where id= :studentid")
	public Student getStudent(int studentid);
}
