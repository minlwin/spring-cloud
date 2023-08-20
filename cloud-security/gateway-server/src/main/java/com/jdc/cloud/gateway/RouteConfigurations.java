package com.jdc.cloud.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfigurations {

	@Bean
	RouteLocator gatewayRoute(RouteLocatorBuilder builder) {
		return builder.routes()
			.route("api/v0/accounts", r -> 
				r.path("/api/account/**").uri("lb://account-api"))
			.route("api/v1/balaces", r -> 
				r.path("/api/balance/**").uri("lb://balance-api"))
			.route("api/v2/members", r -> 
				r.path("/api/member/**").uri("lb://member-api"))
			.build();
	}
	
}
