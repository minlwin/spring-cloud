package com.jdc.spring.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.spring.model.entity.Region;
import com.jdc.spring.model.repo.RegionRepo;

@RestController
@RequestMapping("regions")
public class RegionApi {
	
	@Autowired
	private RegionRepo repo;

	@GetMapping
	List<Region> findAll() {
		return repo.findAll();
	}
}
