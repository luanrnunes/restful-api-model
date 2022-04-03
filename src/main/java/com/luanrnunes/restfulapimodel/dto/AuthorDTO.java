package com.luanrnunes.restfulapimodel.dto;

import java.io.Serializable;

import com.luanrnunes.restfulapimodel.domain.User;

public class AuthorDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	
	public AuthorDTO() {
		
	}
	
	public AuthorDTO(User obj) {
		id = obj.getId();
		setName(obj.getName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
