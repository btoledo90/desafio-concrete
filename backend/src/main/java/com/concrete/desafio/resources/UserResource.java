package com.concrete.desafio.resources;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concrete.desafio.business.UserBusiness;
import com.concrete.desafio.dto.PhoneDTO;
import com.concrete.desafio.dto.UserDTO;
import com.concrete.desafio.dto.UserDTOResponse;
import com.concrete.desafio.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	private UserBusiness userBusiness;

	public UserResource(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

	@PostMapping
	public ResponseEntity<UserDTOResponse> created(@RequestBody UserDTO userDTO) {
		User user = userBusiness.save(userDTO.toUserEntity());
		
		UserDTOResponse userDTOResponse = new UserDTOResponse();
		userDTOResponse.setId(user.getId());
		userDTOResponse.setName(user.getName());
		userDTOResponse.setEmail(user.getEmail());
		userDTOResponse.setPassword(user.getPassword());
		userDTOResponse.setCreated(user.getCreated());
		userDTOResponse.setModified(user.getModified());
		userDTOResponse.setLastLogin(user.getLastLogin());
		userDTOResponse.setToken(user.getToken());
		userDTOResponse
		.setPhones(
				user
				.getPhones()
				.stream()
				.map(phone -> new PhoneDTO(phone.getId(), phone.getNumber(), phone.getDdd()))
				.collect(Collectors.toList())
		);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userDTOResponse);
	}

}
