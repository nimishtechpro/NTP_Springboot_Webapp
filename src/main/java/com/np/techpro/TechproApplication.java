package com.np.techpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TechproApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechproApplication.class, args);
		System.out.println("=== Application Started ! ===");
		System.out.println("URL : http://localhost:8080/api/v1/welcome ");
		System.out.println("Swagger UI : http://localhost:8080/api/v1/swagger-ui/index.html");
		System.out.println("================================");
	}

}
