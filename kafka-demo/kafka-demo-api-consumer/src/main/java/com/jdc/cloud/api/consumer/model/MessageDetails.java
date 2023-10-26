package com.jdc.cloud.api.consumer.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jdc.kafka.events.Message;

public record MessageDetails(
		Message message,
		@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		LocalDateTime receivedAt
		) {

}
