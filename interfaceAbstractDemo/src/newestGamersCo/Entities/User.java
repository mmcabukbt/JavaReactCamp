package newestGamersCo.Entities;

import interfaceAbstractDemo.Abstract.Entity;

public class User implements Entity {
	protected int id;
	protected String password;
	protected String email;
//	private String address; //and other required infos
//	private String mobile;
//	private String city;

	public User() {		
	}
	
	protected User(String password, String email) {
		this.password = password;
		this.email = email;
	}

/*	protected int getId() {
		return id;
	}
/*
	protected void setId(int id) {
		this.id = id;
	} 

	protected String getPassword() {
		return password;
	}

	protected void setPassword(String password) {
		this.password = password;
	}

	protected String getEmail() {
		return email;
	}

	protected void setEmail(String email) {
		this.email = email;
	}//*////
}