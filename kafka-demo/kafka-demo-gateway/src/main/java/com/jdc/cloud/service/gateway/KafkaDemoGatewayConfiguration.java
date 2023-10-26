package com.jdc.cloud.service.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaDemoGatewayConfiguration {

	@Bean
	RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("producer", route -> route.path("/producer/**").uri("lb://producer"))
				.route("consumer", route -> route.path("/consumer/**").uri("lb://consumer"))
				.build();
	}
}
