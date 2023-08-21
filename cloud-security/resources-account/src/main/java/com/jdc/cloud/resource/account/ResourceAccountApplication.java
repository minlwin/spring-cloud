package com.jdc.cloud.resource.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.jdc.cloud.dao.DaoConfiguration;

@SpringBootApplication
@EnableDiscoveryClient
@PropertySource("classpath:/keycloak.properties")
@Import(value = DaoConfiguration.class)
public class ResourceAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceAccountApplication.class, args);
	}
}
