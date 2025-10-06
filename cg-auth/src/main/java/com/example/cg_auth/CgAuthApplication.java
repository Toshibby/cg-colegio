package com.example.cg_auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CgAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(CgAuthApplication.class, args);
	}

}
