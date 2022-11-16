package me.iantapply.scoutingPlatform;

import lombok.RequiredArgsConstructor;
import me.iantapply.scoutingPlatform.data.UserData;
import me.iantapply.scoutingPlatform.data.UserRoles;
import me.iantapply.scoutingPlatform.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
@RequiredArgsConstructor
public class Application {

	final UserService userService;

	public static void main(String[] args) {
		// Run the REST API
		SpringApplication.run(Application.class, args);
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
