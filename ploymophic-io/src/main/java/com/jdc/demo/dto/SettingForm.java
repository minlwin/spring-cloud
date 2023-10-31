package com.jdc.demo.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import lombok.Data;

@Data
@JsonTypeInfo(
		use = Id.NAME,
		include = As.EXISTING_PROPERTY,
		property = "typeInfo"
)
@JsonSubTypes({
	@JsonSubTypes.Type(value = SettingFormFix.class, name = "FIX"),
	@JsonSubTypes.Type(value = SettingFormTeir.class, name = "TEIR")
})
public abstract class SettingForm {

	private String type;
	private String description;
	
	public abstract String getTypeInfo();
}
