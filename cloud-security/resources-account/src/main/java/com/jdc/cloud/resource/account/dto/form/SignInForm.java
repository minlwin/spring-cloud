package com.jdc.cloud.resource.account.dto.form;

import jakarta.validation.constraints.NotEmpty;

public record SignInForm(
		@NotEmpty(message = "Please enter login id.")
		String username,
		@NotEmpty(message = "Please enter password.")
		String password
) {}
