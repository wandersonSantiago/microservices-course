package com.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.exception.WorkerNotFoundException;
import com.microservice.model.Worker;
import com.microservice.repository.WorkerRepository;

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
