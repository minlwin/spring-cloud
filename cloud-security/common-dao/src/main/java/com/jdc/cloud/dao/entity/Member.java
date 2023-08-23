package com.jdc.cloud.dao.entity;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.jdc.cloud.dao.audit.AuditInfo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "seq_member", allocationSize = 1)
@EntityListeners(value = AuditingEntityListener.class)
public class Member {

	@Id
	@GeneratedValue(generator = "seq_member")
	private int id;
	
	@Column(nullable = false, unique = true)
	private String loginId;
	
	@Column(nullable = false)
	private String name;

	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false, name = "regist_at")
	private LocalDate registAt;
	
	private AuditInfo auditInfo = new AuditInfo();
}
