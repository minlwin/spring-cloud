package com.jdc.cloud.dao;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.jdc.cloud.dao.service.OwnerAwareEntityManager;

@Configuration
@EnableAutoConfiguration
@EnableJpaAuditing
@PropertySource("classpath:/application.properties")
public class DaoConfiguration {

	@Bean
	OwnerAwareEntityManager ownerAwareEntityManager() {
		return new OwnerAwareEntityManager();
	}
}
