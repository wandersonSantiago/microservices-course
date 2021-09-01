package com.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.model.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
