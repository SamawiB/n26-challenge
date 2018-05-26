package com.basem.n26.challenge.statistics;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.basem.n26.challenge.domain.TransactionsRequest;
import com.basem.n26.challenge.util.DateUtil;

@Component
public class StatisticsCalculator {

	public Statistics calculateLastMinuteStatistics(List<TransactionsRequest> transactionsList) {

		double sum = 0;
		double avg = 0;
		double max = 0;
		double min = Double.MAX_VALUE;
		double count = 0;

		Date boundDate = DateUtil.getSecondsAgoDate(60);
		for (Iterator<TransactionsRequest> iterator = transactionsList.iterator(); iterator.hasNext();) {
			TransactionsRequest transactionsRequest = iterator.next();

			if (transactionsRequest.getTimestamp().after(boundDate)) {
				Double amount = transactionsRequest.getAmount();
				sum += amount;
				max = Double.max(max, amount);
				min = Double.min(min, amount);
				count++;
			}
		}
		if (count != 0) {
			avg = sum / count;
		} else {
			min = 0;
		}
		return new Statistics(sum, avg, max, min, count);
	}

}
