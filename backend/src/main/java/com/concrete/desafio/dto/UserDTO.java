package com.concrete.desafio.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	 
	private Long id;
	
	@NotBlank(message = "Campo obrigatório")
	private String name;
	
	@Email(message = "E-mail já existe")
	private String email;
	
	private String password;	

}