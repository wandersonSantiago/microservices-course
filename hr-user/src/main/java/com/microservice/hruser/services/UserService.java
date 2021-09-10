package com.microservice.hruser.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.hruser.exceptions.UserNotFoundException;
import com.microservice.hruser.models.User;
import com.microservice.hruser.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User findByEmail(String email) {
		return repository.findByEmail(email).orElseThrow(UserNotFoundException::new);
	}

	public User findById(Long id) {
		return repository.findById(id).orElseThrow(UserNotFoundException::new);
	}
}
