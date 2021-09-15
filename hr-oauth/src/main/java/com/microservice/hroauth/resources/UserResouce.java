package com.microservice.hroauth.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.hroauth.dtos.User;
import com.microservice.hroauth.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResouce {

	@Autowired
	private UserService service;

	@GetMapping("/email")
	public User findByEmail(@RequestParam String email) {
		return service.findByEmail(email);
	}
}
