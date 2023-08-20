package com.jdc.cloud.locations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroLocationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroLocationsApplication.class, args);
	}

}
