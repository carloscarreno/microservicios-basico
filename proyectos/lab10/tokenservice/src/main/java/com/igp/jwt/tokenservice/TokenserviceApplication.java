package com.igp.jwt.tokenservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TokenserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TokenserviceApplication.class, args);
	}

}
