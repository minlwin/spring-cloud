package com.jdc.cloud.resource.account.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class KeycloakRequestService {
	
	@Value("${app.keycloak.base_url}")
	private String baseUrl;
	@Value("${app.keycloak.realm}")
	private String realm;

	public WebClient getClient() {
		return WebClient.builder()
				.baseUrl("%s/%s/protocol/openid-connect".formatted(baseUrl, realm))
				.build();
	}
	
}
