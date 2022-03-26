package com.desafio.cadastromongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class CadastroMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroMongodbApplication.class, args);
	}

}
