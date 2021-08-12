package com.mt.springdatajpaemp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id
	private int id;
	private String city;
	private int code;
	@OneToOne(cascade = CascadeType.ALL)
	private Employee employee;

	public Address() {
		super();
	}

	public Address(int id, String city, int code, Employee employee) {
		super();
		this.id = id;
		this.city = city;
		this.code = code;
		this.employee = employee;
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

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", code=" + code + ", employee=" + employee + "]";
	}

}
