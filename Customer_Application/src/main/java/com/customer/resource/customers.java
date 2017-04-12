package com.customer.resource;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class customers {
	
	

	public customers(){
		
	}
	
	public customers(String id, String firstname , String lastname,String email ){
		super();
		this.id = id;
		this.firstname =firstname;
		this.lastname=lastname;
		
		this.email=email;
	}
	
	@Id
	private String id;
	private String firstname;

	private String lastname;

	private String email;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	}

	
	
	
	


