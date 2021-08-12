package com.mt.ims.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stocks")
public class Stock implements Comparable<Stock>,Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String productType;
	private double price;
	private int quantity;
	@Override
	public int compareTo(Stock o) {
		int compare=productType.compareTo(o.productType);
		if(compare==0)
		{
			compare=Double.compare(price, o.price);
		}
		return compare;
	}
	
}
