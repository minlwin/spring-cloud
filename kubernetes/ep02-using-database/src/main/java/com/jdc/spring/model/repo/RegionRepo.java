package com.jdc.spring.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.spring.model.entity.Region;

public interface RegionRepo extends JpaRepository<Region, Integer>{

}