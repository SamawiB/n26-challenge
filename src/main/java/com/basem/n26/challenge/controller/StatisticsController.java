package com.basem.n26.challenge.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basem.n26.challenge.domain.StatisticsResponse;
import com.basem.n26.challenge.domain.TransactionsRequest;
import com.basem.n26.challenge.service.StatisticsService;

@RestController
public class StatisticsController {

	private StatisticsService statisticsService;

	@Autowired
	public StatisticsController(StatisticsService statisticsService) {
		super();
		this.statisticsService = statisticsService;
	}

	@GetMapping
	@RequestMapping(value = "/statistics", produces = "application/json")
	public ResponseEntity<StatisticsResponse> getstatistics() {
		return new ResponseEntity<>(statisticsService.getstatistics(), HttpStatus.OK);
	}

	@PostMapping
	@RequestMapping(value = "/transactions", consumes = "application/json")
	public ResponseEntity<String> addTransaction(
			@RequestBody(required = true) @Valid TransactionsRequest transactionsRequest) {

		boolean created = statisticsService.addTransaction(transactionsRequest);
		if (created)
			return new ResponseEntity<>("", HttpStatus.CREATED);
		return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
	}

}
