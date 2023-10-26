package com.jdc.kafka.events;

public record Message(
		String type,
		String message
		) {

}
