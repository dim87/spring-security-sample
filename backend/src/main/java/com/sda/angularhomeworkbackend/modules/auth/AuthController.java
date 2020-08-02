package com.sda.angularhomeworkbackend.modules.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.sda.angularhomeworkbackend.modules.users.UserTO;

@RestController
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private SecurityService securityService;

	@PostMapping("/login")
	public AuthenticationResult authenticate(@RequestBody UserTO userTO) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userTO.getEmail(), userTO.getPassword()));
		} catch (Exception e) {
			throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "Bad credentials");
		}

		return new AuthenticationResult(securityService.generateToken(securityService.loadUserByUsername(userTO.getEmail())));
	}
}
