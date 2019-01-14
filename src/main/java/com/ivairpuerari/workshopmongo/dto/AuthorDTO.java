package com.ivairpuerari.workshopmongo.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import com.ivairpuerari.workshopmongo.domain.User;

public class AuthorDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name;

	public AuthorDTO() {
		// TODO Auto-generated constructor stub
	}

	public AuthorDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
