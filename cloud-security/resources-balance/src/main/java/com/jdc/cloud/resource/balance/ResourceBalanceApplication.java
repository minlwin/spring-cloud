package com.jdc.cloud.resource.balance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import com.jdc.cloud.dao.DaoConfiguration;

@SpringBootApplication
@EnableDiscoveryClient
@Import(value = DaoConfiguration.class)
public class ResourceBalanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResourceBalanceApplication.class, args);
	}
}
