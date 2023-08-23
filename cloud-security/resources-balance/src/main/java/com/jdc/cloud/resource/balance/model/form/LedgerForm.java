package com.jdc.cloud.resource.balance.model.form;

import com.jdc.cloud.dao.constants.LedgerType;
import com.jdc.cloud.dao.entity.Ledger;

public record LedgerForm(
		LedgerType type,
		String name
		) {

	public Ledger entity() {
		var entity = new Ledger();
		entity.setType(type);
		entity.setName(name);
		return entity;
	}
}
