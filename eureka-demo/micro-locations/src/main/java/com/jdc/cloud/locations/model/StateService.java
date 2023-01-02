package com.jdc.cloud.locations.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc.cloud.locations.model.entity.State;
import com.jdc.cloud.locations.model.repo.StateRepo;

@Service
public class StateService {

	@Autowired
	private StateRepo repo;

	public List<State> findAll() {
		return repo.findAll();
	}

	public State findById(int id) {
		return repo.findById(id).orElseThrow();
	}
	
	
}
