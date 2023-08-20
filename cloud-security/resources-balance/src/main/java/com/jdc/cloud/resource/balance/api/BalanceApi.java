package com.jdc.cloud.resource.balance.api;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.cloud.model.dto.PageResult;
import com.jdc.cloud.resource.balance.model.dto.BalanceDto;
import com.jdc.cloud.resource.balance.service.TransactionService;

@RestController
@RequestMapping("reports")
public class BalanceApi {
	
	@Autowired
	private TransactionService service;

	@GetMapping
	public PageResult<BalanceDto> search(
			@RequestParam Optional<Integer> ledger,
			@RequestParam Optional<LocalDate> from,
			@RequestParam Optional<LocalDate> to) {
		return service.searchBalance(ledger, from, to);
	}
}
