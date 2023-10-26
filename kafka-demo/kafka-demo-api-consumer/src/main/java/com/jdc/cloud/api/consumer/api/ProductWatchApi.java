package com.jdc.cloud.api.consumer.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.cloud.api.consumer.model.MessageDetails;
import com.jdc.cloud.api.consumer.model.MessageRepository;

@RestController
@RequestMapping("logs")
public class ProductWatchApi {

	@Autowired
	private MessageRepository repository;
	
	@GetMapping
	public List<MessageDetails> getAll() {
		return repository.getData();
	}
}
