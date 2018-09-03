package com.listecourses.models;

public class Article {
	
	//VARIABLES	
	private long id;
	private String name;
	private User_ user;
	private String mesureUnit;
	
	// CONSTRUCTEUR 
	public Article(String name, User_ user) {
		super();
		this.name = name;
		this.user = user;
	}

	
	
	// GETTERS ET SETTERS ***************
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public User_ getUser() {
		return user;
	}

	public void setUser(User_ user) {
		this.user = user;
	}

	public String getMesureUnit() {
		return mesureUnit;
	}

	public void setMesureUnit(String mesureUnit) {
		this.mesureUnit = mesureUnit;
	}
	
	

} // Fin class Article




