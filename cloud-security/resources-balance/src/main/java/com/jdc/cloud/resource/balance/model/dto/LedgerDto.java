package com.jdc.cloud.resource.balance.model.dto;

import com.jdc.cloud.dao.constants.LedgerType;
import com.jdc.cloud.dao.entity.Ledger;

public record LedgerDto(
		int id,
		LedgerType type,
		String name
		) {

	public static LedgerDto from(Ledger ledger) {
		return new LedgerDto(ledger.getId(), ledger.getType(), ledger.getName());
	}
}
