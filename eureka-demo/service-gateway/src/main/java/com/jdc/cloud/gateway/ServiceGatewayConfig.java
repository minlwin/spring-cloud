package com.jdc.cloud.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ServiceGatewayConfig {

	@Bean
	RouteLocator gatewayRoute(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("locations", r -> 
					r.path("/locations/**").uri("lb://locations")).build();
	}
	
}
