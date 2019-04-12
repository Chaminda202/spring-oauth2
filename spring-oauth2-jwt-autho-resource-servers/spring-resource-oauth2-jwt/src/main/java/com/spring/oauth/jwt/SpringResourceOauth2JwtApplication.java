package com.spring.oauth.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class SpringResourceOauth2JwtApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringResourceOauth2JwtApplication.class, args);
	}
}
