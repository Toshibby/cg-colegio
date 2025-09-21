package com.upeu.cg_matricula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CgMatriculaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CgMatriculaApplication.class, args);
	}

}
