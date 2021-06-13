package com.concrete.desafio.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	 
	private Long id;
	
	@NotBlank(message = "Campo obrigatório")
	private String name;
<<<<<<< HEAD
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
=======
>>>>>>> parent of 4c7d6dc (Finish register)
	
	@Email(message = "E-mail já existe")
	private String email;
	
	private String password;	

}
