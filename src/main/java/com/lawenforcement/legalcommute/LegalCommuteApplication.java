package com.lawenforcement.legalcommute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LegalCommuteApplication {

	public static void main(String[] args) {
		SpringApplication.run(LegalCommuteApplication.class, args);
	}

}
