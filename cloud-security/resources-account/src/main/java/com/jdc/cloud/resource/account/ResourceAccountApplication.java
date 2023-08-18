package com.jdc.cloud.resource.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:/keycloak.properties")
public class ResourceAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceAccountApplication.class, args);
	}
}
