package com.mt.springbootdemo2.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
 

 
@Entity
@Table(name="employeedetails")
public class Employee {
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id")
    private Long id;
     
    @Column(name="EmployeeName")
    private String employeeName;
     
    @Column(name="EmployeeCode")
    private String employeeCode;
     
    @Column(name="Designation")
    private String designation;
     
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="addressid")
    private Address address;

	public Employee() {
		super();
	}

	public Employee(String employeeName, String employeeCode, String designation) {
		super();
		this.employeeName = employeeName;
		this.employeeCode = employeeCode;
		this.designation = designation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
    
    
}
