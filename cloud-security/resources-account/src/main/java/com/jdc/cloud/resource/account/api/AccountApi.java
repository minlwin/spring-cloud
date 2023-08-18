package com.jdc.cloud.resource.account.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jdc.cloud.resource.account.dto.AccountDto;
import com.jdc.cloud.resource.account.dto.form.SignInForm;
import com.jdc.cloud.resource.account.dto.form.SignUpForm;
import com.jdc.cloud.resource.account.service.KeycloakRequestService;

@RestController
public class AccountApi {
		
	@Autowired
	private KeycloakRequestService requestService;

	@PostMapping("signin")
	public AccountDto signIn(@RequestBody SignInForm form) {
		return null;
	}
	
	@PostMapping("signup")
	public AccountDto signUp(@Validated @RequestBody SignUpForm form, BindingResult result) {
		return null;
	}
}
