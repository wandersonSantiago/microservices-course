package com.microservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.model.Worker;
import com.microservice.service.WorkerService;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	@Autowired
	private WorkerService service;

	@GetMapping
	public List<Worker> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Worker findById(@PathVariable Long id) {
		return service.findById(id);
	}

}
