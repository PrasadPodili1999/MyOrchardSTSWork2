package com.mt.springdatajpa.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "STUDENT")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
property = "id")
public class Student
{
	@Id
	private int id;
	
	private String name;

	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
	private Passport passport;

	public Student()
	{
		super();
	}

	public Student(int id, String name, Passport passport)
	{
		super();
		this.id = id;
		this.name = name;
		this.passport = passport;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Passport getPassport()
	{
		return passport;
	}

	public void setPassport(Passport passport)
	{
		this.passport = passport;
	}

	@Override
	public String toString()
	{
		return "Student [id=" + id + ", name=" + name + ", passport=" + passport + "]";
	}
}