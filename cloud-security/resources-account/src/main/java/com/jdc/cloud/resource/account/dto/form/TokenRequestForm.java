package com.jdc.cloud.resource.account.dto.form;

import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.BodyInserters.FormInserter;

public record TokenRequestForm(
		String clientId,
		String clientSecret,
		String grantType,
		String username,
		String password
		) {
	
	public FormInserter<String> formBody() {
		return BodyInserters.fromFormData("client_id", clientId)
				.with("client_secret", clientSecret)
				.with("grant_type", grantType)
				.with("username", username)
				.with("password", password);
	}
	
	public TokenRequestForm withNameAndPassword(String username, String password) {
		return new TokenRequestForm(clientId, clientSecret, grantType, username, password);
	}
	
	public static TokenRequestForm of(String clientId, String clientSecret, String grantType) {
		return new TokenRequestForm(clientId, clientSecret, grantType, null, null);
	}

}
