package com.mt.springjpaonetoone.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address{

	@Id
	@Column(name="aid")
	private int id;
	@Column(name="city",nullable = true,length = 255)
	private String city;
	@Column(name="state",nullable = true,length = 255)
	private String state;
	@Column(name="zip_code",nullable = true)
	private int zipCode;

	public Address() {
		super();
	}

	public Address(String city, String state, int zipCode) {
		super();
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

//	public Employee getEmp() {
//		return emp;
//	}
//
//	public void setEmp(Employee emp) {
//		this.emp = emp;
//	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + "]";
	}
	
	
}
