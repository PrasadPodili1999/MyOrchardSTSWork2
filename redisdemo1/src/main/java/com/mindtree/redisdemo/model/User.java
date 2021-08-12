package com.mindtree.redisdemo.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{

	private int id;
	private String name;
	private byte age;
	private String gender;
}
