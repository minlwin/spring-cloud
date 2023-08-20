package com.jdc.cloud.resource.balance.model.form;

import java.time.LocalDate;
import java.util.List;

import com.jdc.cloud.dao.entity.Transaction;

public record TransactionForm(
		int ledgerId,
		LocalDate issueAt,
		String remark,
		List<TransactionItemForm> items
		) {

	public Transaction entity() {
		var entity = new Transaction();
		entity.setIssueDate(issueAt);
		entity.setReamark(remark);
		
		for(var item : items) {
			entity.addItem(item.entity());
		}
		
		return entity;
	}
}
