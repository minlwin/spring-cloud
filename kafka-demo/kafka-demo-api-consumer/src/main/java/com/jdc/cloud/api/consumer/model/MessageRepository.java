package com.jdc.cloud.api.consumer.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.jdc.kafka.events.Message;

@Service
public class MessageRepository {
	
	private Logger logger = LoggerFactory.getLogger(MessageRepository.class);

	private List<MessageDetails> data = new ArrayList<>();
	
	@KafkaListener(groupId = "messageGroup", topics = {
			"firstTopic"
	})
	public void add(Message m) {
		data.add(new MessageDetails(m, LocalDateTime.now()));
		logger.info("Received : " + m);
	}
	
	public List<MessageDetails> getData() {
		return new ArrayList<MessageDetails>(data);
	}
}
