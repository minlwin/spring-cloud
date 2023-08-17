package com.jdc.cloud.dao.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "seq_transaction", allocationSize = 1)
public class Transaction {
	
	@Id
	@GeneratedValue(generator = "seq_transaction")
	private long id;
	
	@ManyToOne(optional = false)
	private Member member;
	
	@ManyToOne(optional = false)
	private Ledger ledger;
	
	@Column(name = "issue_date")
	private LocalDate issueDate;
	
	private String reamark;

}
