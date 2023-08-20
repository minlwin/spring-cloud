package com.jdc.cloud.resource.balance.api;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.cloud.dao.constants.LedgerType;
import com.jdc.cloud.model.dto.PageResult;
import com.jdc.cloud.resource.balance.model.dto.TransactionDetailsDto;
import com.jdc.cloud.resource.balance.model.dto.TransactionDto;
import com.jdc.cloud.resource.balance.model.form.TransactionForm;
import com.jdc.cloud.resource.balance.service.TransactionService;

@RestController
@RequestMapping("transactions")
public class TransactionApi {
	
	@Autowired
	private TransactionService service;

	@GetMapping("{type}")
	public PageResult<TransactionDto> search(
			@PathVariable LedgerType type,
			@RequestParam Optional<Integer> ledger,
			@RequestParam Optional<LocalDate> from,
			@RequestParam Optional<LocalDate> to			
			) {
		return service.search(type, ledger, from, to);
	}
	
	@GetMapping("{id}")
	public TransactionDetailsDto findById(@PathVariable long id) {
		return service.findById(id);
	}
	
	
	@PostMapping
	public TransactionDetailsDto create(@RequestBody TransactionForm form) {
		return service.create(form);
	}

	@PutMapping("{id}")
	public TransactionDetailsDto update(@PathVariable long id, 
			@RequestBody TransactionForm form) {
		return service.update(id, form);
	}
}
