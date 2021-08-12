package com.mt.fms.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "directors")
public class Director {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private byte age;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "award_count")
	private byte awardCount;
	
	@ManyToMany(mappedBy = "directors")
	@JsonIgnore
	private Set<Film> films;

	public Director(int id, String name, byte age, String gender, byte awardCount) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.awardCount = awardCount;
	}
	
	
	
	
}
