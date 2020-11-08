package com.javaDemo.springBootOneToMany.Entities;

public class AuthRequest implements IEntity{
	
	private String email;
	private String password;
	
	public AuthRequest(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public AuthRequest() {}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
