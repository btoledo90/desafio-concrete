package com.concrete.desafio.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concrete.desafio.entities.User;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@PostMapping
	public ResponseEntity<User> created(@RequestBody  User user) {
		user.setId(34323L);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);

	}

}
