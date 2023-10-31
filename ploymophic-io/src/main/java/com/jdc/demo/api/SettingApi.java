package com.jdc.demo.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.demo.dto.SettingForm;

@RestController
@RequestMapping("settings")
public class SettingApi {
	
	private List<SettingForm> list = new ArrayList<SettingForm>();
	
	@GetMapping
	public List<SettingForm> findAll() {
		return list;
	}

	@PostMapping
	public SettingForm create(@RequestBody SettingForm form) {
		System.out.println(form);
		list.add(form);
		return form;
	}
}
