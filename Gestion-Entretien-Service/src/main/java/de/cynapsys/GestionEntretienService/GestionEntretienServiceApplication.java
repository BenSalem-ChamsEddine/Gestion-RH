package de.cynapsys.GestionEntretienService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class GestionEntretienServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionEntretienServiceApplication.class, args);
	}
}
