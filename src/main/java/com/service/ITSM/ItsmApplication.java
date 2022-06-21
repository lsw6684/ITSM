package com.service.ITSM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ItsmApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItsmApplication.class, args);
	}

}
