package com.mt.manytomanydemo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "courses")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private byte durationInYears;
	
//	@OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
//	private Set<StudentCourse> sc=new HashSet<>();

	public Course(String name, byte durationInYears, Set<StudentCourse> sc) {
		super();
		this.name = name;
		this.durationInYears = durationInYears;
		//this.sc = sc;
	}
	
	
	
	
}
