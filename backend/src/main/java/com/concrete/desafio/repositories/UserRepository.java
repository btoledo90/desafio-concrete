package com.concrete.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.concrete.desafio.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
