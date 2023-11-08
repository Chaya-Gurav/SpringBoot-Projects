package com.springboot.movieticktes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.springboot.movieticktes.repository")
@EntityScan("com.springboot.movieticktes.entities")
public class SpringBootExampleMovieTicketsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExampleMovieTicketsApplication.class, args);
	}

}
