package com.basem.n26.challenge.domain;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class TransactionsRequest {

	@NotNull
	private Double amount;

	@NotNull
	private Date timestamp;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}