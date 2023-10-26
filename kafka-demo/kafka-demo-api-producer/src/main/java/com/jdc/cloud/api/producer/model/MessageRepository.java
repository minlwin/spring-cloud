package com.jdc.cloud.api.producer.model;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.jdc.kafka.events.Message;

@Service
public class MessageRepository {

	private List<Message> data = new ArrayList<Message>();
	private Logger logger = LoggerFactory.getLogger(MessageRepository.class);
	
	@Autowired
	private KafkaTemplate<String, Message> kafkaTemplate;
	
	public void add(Message m) {
		data.add(m);
		logger.info("Accept : " + m);
		
		kafkaTemplate.send("firstTopic", m).whenComplete((result, error) -> {
			if(null != error) {
				logger.error("Fail to Send Event");
				error.printStackTrace();
			} else {
				logger.info("Send event successfully!");
			}
		});
		
	}
	
	public List<Message> getData() {
		return new ArrayList<Message>(data);
	}
}
