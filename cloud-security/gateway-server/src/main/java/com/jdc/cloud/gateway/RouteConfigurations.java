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
			.route("account-api", r -> 
				r.path("/account-api/**").uri("lb://account-api"))
			.route("balance-api", r -> 
				r.path("/balance-api/**").uri("lb://balance-api"))
			.route("member-api", r -> 
				r.path("/member-api/**").uri("lb://member-api"))
			.build();
	}
	
}
