package com.jdc.cloud.resource.balance.model.dto;

import java.time.LocalDate;

import com.jdc.cloud.dao.constants.LedgerType;

public record TransactionDto(
		long id,
		LocalDate issueAt,
		int ledgerId,
		LedgerType type,
		String ledger,
		int total,
		String remark
		) {

}
