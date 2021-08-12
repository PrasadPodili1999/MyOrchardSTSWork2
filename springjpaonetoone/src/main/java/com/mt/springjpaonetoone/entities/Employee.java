package com.mt.springjpaonetoone.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="emp")
public class Employee{

	@Id
	@Column(name="eid")
	private int id;
	
	@Column(name="ename",nullable = true,length = 255)
	private String name;
	
	@Column(name="sal",nullable = true)
	private double sal;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address add;

	public Employee(String name, double sal) {
		super();
		this.name = name;
		this.sal = sal;
	}

	public Employee() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public Address getAdd() {
		return add;
	}

	public void setAdd(Address add) {
		this.add = add;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", sal=" + sal + ", add=" + add + "]";
	}
	
	
}
