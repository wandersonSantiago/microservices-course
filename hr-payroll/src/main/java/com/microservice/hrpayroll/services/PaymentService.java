package com.microservice.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.hrpayroll.feignclients.WorkerFeignClient;
import com.microservice.hrpayroll.models.Payment;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient client;

	public Payment getPayment(long workerId, int days) {

		var worker = client.findById(workerId);

		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
