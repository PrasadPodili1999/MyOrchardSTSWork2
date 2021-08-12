package com.mindtree.cmm.model;

public class CampusMind{

	private int id;
	private String name;
	private String location;
	private int projectId;
	public CampusMind() {
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public CampusMind(int id, String name, String location, int projectId) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.projectId = projectId;
	}
	
	
}
