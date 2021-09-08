package com.microservice.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.hrpayroll.models.Payment;
import com.microservice.hrpayroll.models.Worker;

@Service
public class PaymentService {

	@Value("${hr-worker.host}")
	private String workerHost;

	@Autowired
	private RestTemplate restTemplate;

	public Payment getPayment(long workerId, int days) {

		var worker = restTemplate.getForObject(workerHost + "/workers/" + workerId, Worker.class);

		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
