package com.jdc.cloud.api.producer.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.cloud.api.producer.model.MessageRepository;
import com.jdc.kafka.events.Message;

@RestController
@RequestMapping("create")
public class MessageReceiver {

	@Autowired
	private MessageRepository repository;
	
	@PostMapping
	public List<Message> create(@RequestBody Message message) {
		repository.add(message);
		return repository.getData();
	}
}
