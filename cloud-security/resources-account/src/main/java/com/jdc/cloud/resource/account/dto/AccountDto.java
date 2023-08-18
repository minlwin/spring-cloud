package com.jdc.cloud.resource.account.dto;

public record AccountDto(
		String name,
		String username,
		String accessToken,
		String refreshToken
		){

	public static AccountDto from(UserInfoResponse userInfo, TokenResponse token) {
		return new AccountDto(userInfo.name(), userInfo.username(), token.accessToken(), token.refreshToken());
	}
}
