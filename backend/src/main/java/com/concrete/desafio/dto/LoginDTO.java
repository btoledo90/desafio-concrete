package com.concrete.desafio.dto;

import java.io.Serializable;

import com.concrete.desafio.entities.User;

public class LoginDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String email;
	private String password;
	
	

	public LoginDTO() {
		super();
	}

	public LoginDTO(Long id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public LoginDTO(User entity) {
		id = entity.getId();
		email = entity.getEmail();
		password = entity.getPassword();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
