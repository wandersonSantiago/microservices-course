package com.microservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.models.Worker;
import com.microservice.services.WorkerService;

import lombok.extern.log4j.Log4j2;


@Log4j2
@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	@Value("${test.config}")
	private String testConfig;
	
	@Autowired
	private WorkerService service;

	@Autowired
	private Environment environment;

	
	@GetMapping(value="/configs")
	public void config() {
		log.info("Config => " + testConfig);
	}
	
	@GetMapping
	public List<Worker> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Worker findById(@PathVariable Long id) {
		log.info("PORT = " + environment.getProperty("local.server.port"));

		return service.findById(id);
	}

}
