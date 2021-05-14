package com.finovate.contact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ContactServiceApplication {
	@Bean
	public RestTemplate rt() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(ContactServiceApplication.class, args);
	}
	

}
