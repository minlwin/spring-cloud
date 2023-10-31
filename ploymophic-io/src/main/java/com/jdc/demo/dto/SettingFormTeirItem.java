package com.jdc.demo.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class SettingFormTeirItem  {

	private String name;
	private BigDecimal from;
	private BigDecimal to;
}
