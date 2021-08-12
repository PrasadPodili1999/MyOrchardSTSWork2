package com.mt.fms.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
@Table(name = "films")
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "boxoffice_collection")
	private double boxOfficeCollection;
	
	@Column(name = "rating")
	private byte rating;
	
	@ManyToMany(cascade = { CascadeType.MERGE })
	@JoinTable(name = "director_films",
		joinColumns = {@JoinColumn(name = "film_id")},
		inverseJoinColumns = {@JoinColumn(name = "director_id")})
	private Set<Director> directors;

	public Film(int id, String name, double boxOfficeCollection, byte rating) {
		super();
		this.id = id;
		this.name = name;
		this.boxOfficeCollection = boxOfficeCollection;
		this.rating = rating;
	}
	
	
}
