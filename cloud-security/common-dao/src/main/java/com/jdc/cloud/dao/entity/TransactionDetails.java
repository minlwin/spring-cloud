package com.jdc.cloud.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "seq_transaction_details", allocationSize = 1)
public class TransactionDetails {

	@Id
	@GeneratedValue(generator = "seq_transaction_details")
	private long id;
	
	@ManyToOne(optional = false)
	private Transaction transaction;
	
	@Column(nullable = false)
	private String item;
	
	@Column(nullable = false)
	private int quantity;
	
	@Column(nullable = false, name = "unit_price")
	private int unitPrice;
}
