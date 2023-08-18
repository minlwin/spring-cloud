package com.jdc.cloud.resource.account.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;

import com.jdc.cloud.resource.account.dto.AccountDto;
import com.jdc.cloud.resource.account.dto.TokenResponse;
import com.jdc.cloud.resource.account.dto.UserInfoResponse;
import com.jdc.cloud.resource.account.dto.form.SignInForm;
import com.jdc.cloud.resource.account.dto.form.SignUpForm;
import com.jdc.cloud.resource.account.service.KeycloakRequestService;

@RestController
public class AccountApi {

	@Autowired
	private KeycloakRequestService requestService;

	@Value("${app.keycloak.client_id}")
	private String clientId;

	@Value("${app.keycloak.client_secret}")
	private String clientSecret;

	private static final String KEY_CLIENT_ID = "client_id";
	private static final String KEY_CLIENT_SECRET = "client_secret";
	private static final String KEY_GRANT_TYPE = "grant_type";
	private static final String KEY_USERNAME = "username";
	private static final String KEY_PASSWORD = "password";

	@PostMapping("signin")
	public AccountDto signIn(@RequestBody SignInForm form) {
		return requestService.getClient().post().uri(uri -> uri.path("/token").build())
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.body(BodyInserters.fromFormData(KEY_CLIENT_ID, clientId)
						.with(KEY_CLIENT_SECRET, clientSecret)
						.with(KEY_GRANT_TYPE, "password").with(KEY_USERNAME, form.username())
						.with(KEY_PASSWORD, form.password()))
				.retrieve().bodyToMono(TokenResponse.class)
				.flatMap(token -> requestService.getClient().get().uri(uri -> uri.path("/userinfo").build())
						.accept(MediaType.APPLICATION_JSON)
						.header("Authorization", "%s %s".formatted(token.tokenType(), token.accessToken())).retrieve()
						.bodyToMono(UserInfoResponse.class).map(userInfo -> {
							return AccountDto.from(userInfo, token);
						}))
				.block();
	}

	@PostMapping("signup")
	public AccountDto signUp(@Validated @RequestBody SignUpForm form, BindingResult result) {
		return null;
	}
}
