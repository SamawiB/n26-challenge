package com.basem.n26.challenge.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.basem.n26.challenge.domain.TransactionsRequest;

@Component
public class DataWrapper {

	private List<TransactionsRequest> transactionsList = new ArrayList<>();

	public synchronized void addItem(TransactionsRequest request) {
		transactionsList.add(request);
	}

	public synchronized List<TransactionsRequest> getTransactionsList() {
		return new ArrayList<>(transactionsList);
	}

}
