package com.jdc.cloud.locations.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.cloud.locations.model.entity.State;

public interface StateRepo extends JpaRepository<State, Integer>{

}
