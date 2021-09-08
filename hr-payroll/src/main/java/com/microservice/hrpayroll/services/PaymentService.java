package com.microservice.hrpayroll.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.hrpayroll.feignclients.WorkerFeignClient;
import com.microservice.hrpayroll.models.Payment;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient client;

	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	public Payment getPayment(long workerId, int days) {

		var worker = client.findById(workerId);

		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
	
	public Payment getPaymentAlternative(long workerId, int days) {
		return new Payment("Alternative", BigDecimal.valueOf(500.00), days);
	}
}
