package com.basem.n26.challenge.service;

import com.basem.n26.challenge.domain.StatisticsResponse;
import com.basem.n26.challenge.domain.TransactionsRequest;

public interface StatisticsService {
	
	public StatisticsResponse getstatistics();

	public boolean addTransaction(TransactionsRequest transactionsRequest);

}
