package com.jdc.demo.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SettingFormFix extends SettingForm{

	private BigDecimal amount;
	private BigDecimal percent;
	
	@Override
	public String getTypeInfo() {
		return "FIX";
	}
}
