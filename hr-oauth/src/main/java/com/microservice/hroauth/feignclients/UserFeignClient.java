package com.microservice.hroauth.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.hroauth.dtos.User;

@Component
@FeignClient(name = "hr-user", path = "/users")
public interface UserFeignClient {

	@GetMapping("/email/{email}")
	User findByEmail(@PathVariable String email);
}
