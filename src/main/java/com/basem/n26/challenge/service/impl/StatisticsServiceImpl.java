package com.basem.n26.challenge.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basem.n26.challenge.data.DataWrapper;
import com.basem.n26.challenge.domain.StatisticsResponse;
import com.basem.n26.challenge.domain.TransactionsRequest;
import com.basem.n26.challenge.service.StatisticsService;
import com.basem.n26.challenge.statistics.Statistics;
import com.basem.n26.challenge.statistics.StatisticsCalculator;
import com.basem.n26.challenge.util.DateUtil;

@Service
public class StatisticsServiceImpl implements StatisticsService {

	@Autowired
	private DataWrapper dataWrapper;

	@Autowired
	private StatisticsCalculator statisticsCalculator;

	public StatisticsResponse getstatistics() {

		List<TransactionsRequest> transactionsList = dataWrapper.getTransactionsList();

		if (transactionsList.isEmpty())
			return new StatisticsResponse.Builder().build();

		Statistics statistics = statisticsCalculator.calculateLastMinuteStatistics(transactionsList);

		return new StatisticsResponse.Builder().sum(statistics.getSum()).avg(statistics.getAvg())
				.max(statistics.getMax()).min(statistics.getMin()).count(statistics.getCount()).build();

	}

	public boolean addTransaction(TransactionsRequest transactionsRequest) {

		Date boundDate = DateUtil.getSecondsAgoDate(60);
		if (transactionsRequest.getTimestamp().before(boundDate)) {
			return false;
		}
		dataWrapper.addItem(transactionsRequest);
		return true;
	}

}
