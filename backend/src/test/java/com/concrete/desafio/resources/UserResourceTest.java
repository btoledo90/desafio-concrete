package com.concrete.desafio.resources;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.http.HttpHeaders;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import com.concrete.desafio.dto.UserDTO;
import com.concrete.desafio.entities.User;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class UserResourceTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void deveValidarStatusCode201() throws Exception {
		
		RequestBuilder request = post("/usuarios")
				.content("{\r\n"
				+ "       \"name\": \"João da Silva\",\r\n"
				+ "       \"email\": \"joao@silva.org\",\r\n"
				+ "       \"password\": \"hunter2\",\r\n"
				+ "       \"phones\": [\r\n"
				+ "           {\r\n"
				+ "               \"number\": \"987654321\",\r\n"
				+ "               \"ddd\": \"21\"\r\n"
				+ "           }\r\n"
				+ "       ]\r\n"
				+ "   }")
				.contentType(MediaType.APPLICATION_JSON);
		
		mockMvc
		.perform(request)
		.andExpect(status().isCreated());
	}
	
	@Test
	public void deveValidarAtributoIdNaoNulo() throws Exception {
		
		RequestBuilder request = post("/usuarios")
				.content("{\r\n"
				+ "       \"name\": \"João da Silva\",\r\n"
				+ "       \"email\": \"joao@silva.org\",\r\n"
				+ "       \"password\": \"hunter2\",\r\n"
				+ "       \"phones\": [\r\n"
				+ "           {\r\n"
				+ "               \"number\": \"987654321\",\r\n"
				+ "               \"ddd\": \"21\"\r\n"
				+ "           }\r\n"
				+ "       ]\r\n"
				+ "   }")
				.contentType(MediaType.APPLICATION_JSON);
		
		mockMvc
		.perform(request)
		.andExpect(jsonPath("$.id").isNotEmpty());	
		
		
	}
	
	
		
		

}
