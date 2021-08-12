package com.mt.mtm.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JoinTable(name = "student_course", 
		joinColumns = {@JoinColumn(name="student_id")},
		inverseJoinColumns = {@JoinColumn(name="course_id")})
	private Set<Course> courses;
	
	public void addCourse(Course course) {
        this.courses.add(course);
        course.getStudents().add(this);
    }
 
    public void removeCourse(Course course) {
        this.getCourses().remove(course);
        course.getStudents().remove(this);
    }
 
    public void removeCourses() {
        for (Course course : new HashSet<>(courses)) {
            removeCourse(course);
        }
    }
}
