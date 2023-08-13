package com.jdc.cloud.config.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.cloud.config.model.ResultValue;

@RestController
public class DemoApi {

	@Value("${service.one.value}")
	private int value;
	@Value("${application.message}")
	private String message;
	
	@GetMapping("hello")
	ResultValue index() {
		return new ResultValue(value, message);
	}
}
