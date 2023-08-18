package com.jdc.cloud.resource.account.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserInfoResponse(
		@JsonProperty("preferred_username")
		String username,
		@JsonProperty("given_name")
		String firstName,
		@JsonProperty("family_name")
		String lastName,
		String email
		) {
	
	public String name() {
		return "%s %s".formatted(firstName, lastName);
	}
}
