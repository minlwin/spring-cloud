package com.jdc.cloud.resource.balance.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.cloud.dao.constants.LedgerType;
import com.jdc.cloud.resource.balance.model.dto.LedgerDto;
import com.jdc.cloud.resource.balance.model.form.LedgerForm;
import com.jdc.cloud.resource.balance.service.LedgerService;

@RestController
@RequestMapping("ledgers")
public class LedgerApi {
	
	@Autowired
	private LedgerService service;

	@GetMapping
	List<LedgerDto> search(
			@RequestParam Optional<LedgerType> type, 
			@RequestParam Optional<String> name) {
		return service.search(type, name);
	}
	
	@PostMapping
	LedgerDto create(@Validated @RequestBody LedgerForm form, BindingResult result) {
		return service.create(form);
	}
	
	@GetMapping("{id}")
	LedgerDto findById(int id) {
		return service.findById(id);
	}
	
	@PutMapping("{id}")
	LedgerDto update(@PathVariable int id, @Validated @RequestBody LedgerForm form, BindingResult result) {
		return service.update(id, form);
	}
	
}
