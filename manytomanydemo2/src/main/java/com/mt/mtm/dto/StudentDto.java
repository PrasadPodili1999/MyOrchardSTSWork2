package com.mt.mtm.dto;

import java.util.HashSet;
import java.util.Set;

import com.mt.mtm.model.Course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

	private int id;
	private String name;
	private Set<String> courses=new HashSet<>();
}
