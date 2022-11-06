package me.iantapply.scoutingPlatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// Run the REST API
		SpringApplication.run(Application.class, args);
	}
}
