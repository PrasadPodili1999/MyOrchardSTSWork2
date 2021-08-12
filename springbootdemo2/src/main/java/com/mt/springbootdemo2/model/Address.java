package com.mt.springbootdemo2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

 
@Entity
@Table(name="address")
public class Address {
 
    @Id
    @Column(name="id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
     
    @Column(name="doornumber")
    private String doorNumber;
     
    @Column(name="street")
    private String street;
     
    @Column(name="city")
    private String city;
    @OneToOne(mappedBy = "address")
    private Employee emp;
	public Address() {
		super();
	}

	public Address(String doorNumber, String street, String city) {
		super();
		this.doorNumber = doorNumber;
		this.street = street;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDoorNumber() {
		return doorNumber;
	}

	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
    
    
}
