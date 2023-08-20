package com.jdc.cloud.resource.balance.model.form;

import com.jdc.cloud.dao.entity.TransactionItem;

public record TransactionItemForm(
		String item,
		int unitPrice,
		int quantity
		) {

	public TransactionItem entity() {
		var entity = new TransactionItem();
		entity.setItem(item);
		entity.setQuantity(quantity);
		entity.setUnitPrice(unitPrice);
		return entity;
	}
}
