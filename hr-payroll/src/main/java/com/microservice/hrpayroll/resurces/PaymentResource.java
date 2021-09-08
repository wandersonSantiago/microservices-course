package com.microservice.hrpayroll.resurces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.hrpayroll.models.Payment;
import com.microservice.hrpayroll.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

	@Autowired
	private PaymentService service;

	@GetMapping("/worker-id/{workerId}/days/{days}")
	public Payment getPayment(@PathVariable long workerId, @PathVariable int days) {
		return service.getPayment(workerId, days);
	}
}
