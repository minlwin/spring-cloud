package com.jdc.cloud.service.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class KafkaDemoServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaDemoServiceRegistryApplication.class, args);
	}

}
