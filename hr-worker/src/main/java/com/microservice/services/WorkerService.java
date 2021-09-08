package com.microservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.exceptions.WorkerNotFoundException;
import com.microservice.models.Worker;
import com.microservice.repositories.WorkerRepository;

@Service
public class WorkerService {

	@Autowired
	private WorkerRepository repository;

	public List<Worker> findAll() {
		return repository.findAll();
	}

	public Worker findById(Long id) {
		return repository.findById(id).orElseThrow(WorkerNotFoundException::new);
	}
}
