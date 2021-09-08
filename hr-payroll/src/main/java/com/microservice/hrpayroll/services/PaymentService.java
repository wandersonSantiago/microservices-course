package com.microservice.hrpayroll.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.microservice.hrpayroll.models.Payment;

@Service
public class PaymentService {

	public Payment getPayment(long workerId, int days) {
		return new Payment("Bob", BigDecimal.valueOf(200.00), days);
	}
}
