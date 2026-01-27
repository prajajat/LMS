package com.example;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;




@OpenAPIDefinition(
		info = @Info(
				title = "LMS API",
				version = "1.0",
				description = "API documentation "
		)
)
@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		System.out.println("Hello, World!");
	}

}
