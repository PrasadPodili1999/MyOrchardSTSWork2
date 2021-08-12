package com.mt.manytomanydemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "student_course")
public class StudentCourse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "s_id")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "c_id")
	private Course course;
	
	private String description;

	public StudentCourse(Student student, Course course, String description) {
		super();
		this.student = student;
		this.course = course;
		this.description = description;
	}
	
	
}
