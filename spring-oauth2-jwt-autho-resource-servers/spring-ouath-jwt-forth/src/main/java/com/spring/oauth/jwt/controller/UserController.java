package com.spring.oauth.jwt.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@GetMapping
	@RequestMapping("/user")
	public Principal getUser(Principal principal) {
		return principal;
	}
}
