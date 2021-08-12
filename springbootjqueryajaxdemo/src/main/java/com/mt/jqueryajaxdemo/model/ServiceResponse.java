package com.mt.jqueryajaxdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
public class ServiceResponse<T> {

	private String status;
	private T data;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public ServiceResponse(String status, T data) {
		super();
		this.status = status;
		this.data = data;
	}
	public ServiceResponse() {
		super();
	}
	
	
}

