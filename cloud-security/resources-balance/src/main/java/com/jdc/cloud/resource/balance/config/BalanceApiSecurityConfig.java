package com.jdc.cloud.resource.balance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import com.jdc.cloud.model.dto.Role;
import com.jdc.cloud.model.oauth2.converter.ApplicationAuthenticationConverter;

@Configuration
@EnableWebSecurity
public class BalanceApiSecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.csrf(csrf -> csrf.disable());

		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		http.authorizeHttpRequests(request -> {
			request.anyRequest().hasRole(Role.ROLE_CLIENT_MEMBER.getRoleName());
		});
		
		http.oauth2ResourceServer(resource -> {
			resource.opaqueToken(token -> token.authenticationConverter(new ApplicationAuthenticationConverter()));
		});
		
		return http.build();
	}
}
