package com.jdc.cloud.dao.entity;

public interface OwnerAwareEntity {

	Member getOwner();
	
	void setOwner(Member member);
}
