package com.jdc.cloud.model.exception;

import java.util.List;

public class AppValidationException extends RuntimeException implements MessagesEnableException {

	private static final long serialVersionUID = 1L;
	
	private List<String> messages;
	
	public AppValidationException(List<String> messages) {
		super();
		this.messages = messages;
	}

	@Override
	public List<String> getMessages() {
		return messages;
	}

}
