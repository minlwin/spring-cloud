package com.jdc.cloud.dao.audit;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class AuditInfo {

	private boolean active;
	
	@CreatedBy
	@Column(name = "create_by")
	private String createBy;
	
	@LastModifiedBy
	@Column(name = "update_by")
	private String updateBy;
	
	@CreatedDate
	@Column(name = "create_at")
	private LocalDateTime createAt;
	
	@LastModifiedDate
	@Column(name = "update_at")
	private LocalDateTime updateAt;
}
