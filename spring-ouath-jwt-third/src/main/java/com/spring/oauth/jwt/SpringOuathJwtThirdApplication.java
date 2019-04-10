package com.spring.oauth.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.spring.oauth.jwt.entity"})
public class SpringOuathJwtThirdApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOuathJwtThirdApplication.class, args);
	}

}
