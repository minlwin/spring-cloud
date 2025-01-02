package com.jdc.spring.api;

import java.time.DayOfWeek;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DaysApi {

	@GetMapping("/days")
	DayOfWeek[] days() {
		return DayOfWeek.values();
	}
}
