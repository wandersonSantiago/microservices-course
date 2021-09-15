package com.microservice.hroauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.microservice.hroauth.dtos.User;
import com.microservice.hroauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService  {
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	public User findByEmail(String email) {
		return userFeignClient.findByEmail(email);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFeignClient.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("Email not found");
		}
		return user;
	}
	
}
