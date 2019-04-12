package com.spring.oauth.jwt.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping
	@RequestMapping("/test")
	@PreAuthorize("hasAuthority('role_super_admin') or hasAuthority('role_admin')")
	public String helloWorld(){
		return "Hello world...!!!";
	}
}
