package com.jdc.cloud.model.dto;

import java.util.List;

import com.jdc.cloud.model.exception.AppValidationException;
import com.jdc.cloud.model.exception.MessagesEnableException;

public record ErrorResult(
		ErrorType type,
		List<String> messages) {

	public static ErrorResult from(MessagesEnableException ex) {
		
		if(ex instanceof AppValidationException) {
			return new ErrorResult(ErrorType.Validation, ex.getMessages());
		} 
		
		return new ErrorResult(ErrorType.Business, ex.getMessages());
	}
	
	public static ErrorResult platform(String message) {
		return new ErrorResult(ErrorType.Business, List.of(message));
	}
}
