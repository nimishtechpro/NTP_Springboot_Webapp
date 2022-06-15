package com.np.techpro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TechproApplication {
	private static final Logger logger = LoggerFactory.getLogger(TechproApplication.class);
	public static void main(String[] args) {

		SpringApplication.run(TechproApplication.class, args);

		logger.info("=== Application Started ! ===");
		logger.info("URL : http://localhost:8080/api/v1/welcome ");
		logger.info("Swagger UI : http://localhost:8080/api/v1/swagger-ui/index.html");
		logger.info("H2 Database console : http://localhost:8080/api/v1/h2-console/");
		logger.info("Database console : username : sa , Password : password");
		logger.info("================================");
	}

}
