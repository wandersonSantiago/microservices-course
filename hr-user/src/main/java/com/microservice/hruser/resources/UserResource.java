package com.microservice.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.hruser.models.User;
import com.microservice.hruser.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping("/email/{email}")
	public User findByEmail(@PathVariable String email) {
		return service.findByEmail(email);
	}
	
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		return service.findById(id);
	}
}
