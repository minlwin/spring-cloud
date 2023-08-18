package com.jdc.cloud.resource.account.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.jdc.cloud.resource.account.dto.form.TokenRequestForm;

@Service
public class KeycloakRequestService {
	
	@Value("${app.keycloak.base_url}")
	private String baseUrl;
	@Value("${app.keycloak.realm}")
	private String realm;

	@Value("${app.keycloak.client_id}")
	private String clientId;
	@Value("${app.keycloak.client_secret}")
	private String clientSecret;
	
	public WebClient getClient() {
		return WebClient.builder()
				.baseUrl("%s/%s/protocol/openid-connect".formatted(baseUrl, realm))
				.build();
	}
	
	public TokenRequestForm tokenRequestForm() {
		return TokenRequestForm.of(clientId, clientSecret, "password");
	}
}
