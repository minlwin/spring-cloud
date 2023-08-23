package com.jdc.cloud.model.oauth2.converter;

import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.oauth2.server.resource.introspection.OpaqueTokenAuthenticationConverter;

public class ApplicationAuthenticationConverter implements OpaqueTokenAuthenticationConverter{

	@Override
	@SuppressWarnings("unchecked")
	public Authentication convert(String introspectedToken, OAuth2AuthenticatedPrincipal authenticatedPrincipal) {
		
		var attributes = authenticatedPrincipal.getAttributes();
		var resourceAccess = (Map<String, Object>)attributes.getOrDefault("resource_access", Map.of());
		var roles = resourceAccess.values().stream()
				.map(a -> (List<String>)a)
				.flatMap(a -> a.stream())
				.distinct()
				.map(a -> new SimpleGrantedAuthority("ROLE_%s".formatted(a.toUpperCase())))
				.toList();
		
		return UsernamePasswordAuthenticationToken.authenticated(authenticatedPrincipal.getAttribute("preferred_username"), null, roles);
	}

}
