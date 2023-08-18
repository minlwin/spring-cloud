package com.jdc.cloud.resource.account.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TokenResponse(
	@JsonProperty("access_token")
	String accessToken,
	@JsonProperty("refresh_token")
	String refreshToken,
	@JsonProperty("expire_in")
	long expireIn,
	@JsonProperty("refresh_expire_in")
	long refreshExpireIn,
	@JsonProperty("token_type")
	String tokenType,
	String scope
		) {

}
