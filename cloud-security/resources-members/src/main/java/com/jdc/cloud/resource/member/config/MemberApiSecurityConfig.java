package com.jdc.cloud.resource.member.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.jdc.cloud.model.oauth2.converter.ApplicationAuthenticationConverter;

@Configuration
@EnableWebSecurity
public class MemberApiSecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.csrf(csrf -> csrf.disable());
		http.authorizeHttpRequests(request -> request.anyRequest().hasRole("CLIENT_ADMIN"));
		http.oauth2ResourceServer(oauth -> oauth.opaqueToken(token -> token.authenticationConverter(new ApplicationAuthenticationConverter())));
		
		return http.build();
	}
}
