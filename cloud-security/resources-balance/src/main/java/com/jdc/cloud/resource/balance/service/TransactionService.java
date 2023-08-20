package com.jdc.cloud.resource.balance.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.cloud.dao.constants.LedgerType;
import com.jdc.cloud.dao.repo.LedgerRepo;
import com.jdc.cloud.dao.repo.TransactionItemRepo;
import com.jdc.cloud.dao.repo.TransactionRepo;
import com.jdc.cloud.model.dto.PageResult;
import com.jdc.cloud.model.exception.AppBusinessException;
import com.jdc.cloud.resource.balance.model.dto.BalanceDto;
import com.jdc.cloud.resource.balance.model.dto.TransactionDetailsDto;
import com.jdc.cloud.resource.balance.model.dto.TransactionDto;
import com.jdc.cloud.resource.balance.model.form.TransactionForm;

@Service
@Transactional(readOnly = true)
public class TransactionService {
	
	@Autowired
	private TransactionRepo repo;
	
	@Autowired
	private TransactionItemRepo detailsRepo;
	
	@Autowired
	private LedgerRepo ledgerRepo;

	@Transactional
	public TransactionDetailsDto create(TransactionForm form) {
		
		var ledger = ledgerRepo.findById(form.ledgerId())
				.orElseThrow(() -> new AppBusinessException("There is no ledger with id [%d].".formatted(form.ledgerId())));
		
		var entity = form.entity();
		entity.setLedger(ledger);
		
		repo.save(entity);
		
		return TransactionDetailsDto.from(entity);
	}

	@Transactional
	public TransactionDetailsDto update(long id, TransactionForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	public PageResult<BalanceDto> searchBalance(Optional<Integer> ledger, Optional<LocalDate> from,
			Optional<LocalDate> to) {
		// TODO Auto-generated method stub
		return null;
	}

	public PageResult<TransactionDto> search(LedgerType type, Optional<Integer> ledger, Optional<LocalDate> from,
			Optional<LocalDate> to) {
		// TODO Auto-generated method stub
		return null;
	}

	public TransactionDetailsDto findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}


}
