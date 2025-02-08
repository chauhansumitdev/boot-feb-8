package com.example.ordermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class OrdermanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdermanagementApplication.class, args);
	}

}
