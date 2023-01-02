package com.jdc.cloud.locations.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.cloud.locations.model.StateService;
import com.jdc.cloud.locations.model.entity.State;

@RestController
@RequestMapping("states")
public class StateApi {

	@Autowired
	private StateService service;
	
	@GetMapping
	public List<State> findAll() {
		return service.findAll();
	}
	
	@GetMapping("{id}")
	public State findById(@PathVariable int id) {
		return service.findById(id);
	}
}
