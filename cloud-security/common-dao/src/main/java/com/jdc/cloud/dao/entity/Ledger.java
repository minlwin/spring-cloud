package com.jdc.cloud.dao.entity;

import com.jdc.cloud.dao.audit.AuditInfo;
import com.jdc.cloud.dao.constants.LedgerType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Ledger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private LedgerType type;
	
	@ManyToOne(optional = false)
	private Member member;
	
	private AuditInfo auditInfo = new AuditInfo();
}
