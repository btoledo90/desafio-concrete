package com.concrete.desafio.business.impl;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.concrete.desafio.business.UserBusiness;
import com.concrete.desafio.entities.Phone;
import com.concrete.desafio.entities.User;
import com.concrete.desafio.repositories.UserRepository;

@Service
public class UserBusinessImpl implements UserBusiness {

	private UserRepository userRepository;

	public UserBusinessImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User save(User user) {
		user.setCreated(LocalDate.now());
		user.setLastLogin(LocalDate.now());
		user.setToken(UUID.randomUUID());
		
		for(Phone phone : user.getPhones()) {
			phone.setUser(user);
		}

		return userRepository.save(user);
	}

}
