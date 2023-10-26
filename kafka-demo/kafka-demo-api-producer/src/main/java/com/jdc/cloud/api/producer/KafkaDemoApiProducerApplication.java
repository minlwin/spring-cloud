package com.jdc.cloud.api.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
public class KafkaDemoApiProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaDemoApiProducerApplication.class, args);
	}
	
	@Bean
	NewTopic topic() {
		return TopicBuilder.name("firstTopic").build();
	}

}
