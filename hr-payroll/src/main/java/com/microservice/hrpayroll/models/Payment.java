package com.microservice.hrpayroll.models;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

	private String name;
	private BigDecimal dailyIncome;
	private Integer days;

	public BigDecimal getTotal() {
		return dailyIncome.multiply(BigDecimal.valueOf(days));
	}
}
