package com.nixagh.hms_v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
public class HmsApplication {
	public static void main(String[] args) {
		SpringApplication.run(HmsApplication.class, args);
	}

}
