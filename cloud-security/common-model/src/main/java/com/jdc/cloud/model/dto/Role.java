package com.jdc.cloud.model.dto;

public enum Role {
	ROLE_CLIENT_ADMIN, ROLE_CLIENT_MEMBER;
	
	public String getRoleName() {
		return name().substring("ROLE_".length());
	}
}
