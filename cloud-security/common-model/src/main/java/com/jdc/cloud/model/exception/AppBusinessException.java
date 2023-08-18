package com.jdc.cloud.model.exception;

import java.util.List;

public class AppBusinessException extends RuntimeException implements MessagesEnableException{

	private static final long serialVersionUID = 1L;
	
	public AppBusinessException(String message) {
		super(message);
	}

	@Override
	public List<String> getMessages() {
		return List.of(getMessage());
	}
}
