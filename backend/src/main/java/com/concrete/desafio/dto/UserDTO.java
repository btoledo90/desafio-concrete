package com.concrete.desafio.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.concrete.desafio.entities.Phone;
import com.concrete.desafio.entities.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;

	private String email;

	private String password;

	private List<PhoneDTO> phones;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<PhoneDTO> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneDTO> phones) {
		this.phones = phones;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public User toUserEntity() {
		User user = new User();
		user.setName(this.getName());
		user.setEmail(this.getEmail());
		user.setPassword(this.getPassword());
		List<Phone> phones = this.getPhones()
		.stream()
		.map(phoneDTO -> new Phone(phoneDTO.getId(), phoneDTO.getNumber(), phoneDTO.getDdd()))
		.collect(Collectors.toList()); 
		user.setPhones(phones);
		
		return user;
	
		
	}

}
