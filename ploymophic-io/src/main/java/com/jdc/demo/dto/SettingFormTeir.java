package com.jdc.demo.dto;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SettingFormTeir extends SettingForm{

	private List<SettingFormTeirItem> items;

	@Override
	public String getTypeInfo() {
		return "TEIR";
	}
}
