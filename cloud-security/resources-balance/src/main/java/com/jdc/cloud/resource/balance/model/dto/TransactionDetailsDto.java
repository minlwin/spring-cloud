package com.jdc.cloud.resource.balance.model.dto;

import java.time.LocalDate;
import java.util.List;

import com.jdc.cloud.dao.constants.LedgerType;
import com.jdc.cloud.dao.entity.Transaction;

public record TransactionDetailsDto(
		long id,
		LocalDate issueAt,
		int ledgerId,
		LedgerType type,
		String ledger,
		String remark,
		List<TransactionItemDto> items) {
	
	public int total() {
		return items.stream().mapToInt(a -> a.total()).sum();
	}

	public static TransactionDetailsDto from(Transaction entity) {
		// TODO Auto-generated method stub
		return null;
	}
}
