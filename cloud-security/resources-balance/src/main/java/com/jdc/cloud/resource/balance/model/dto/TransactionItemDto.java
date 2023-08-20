package com.jdc.cloud.resource.balance.model.dto;

public record TransactionItemDto(
	String item,
	int quantity,
	int unitPrice) {

	public int total() {
		return quantity * unitPrice;
	}
}
