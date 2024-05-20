package com.luv2code.springboot.crudemployeedemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudemployeedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudemployeedemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(String []args){
		return runner ->{
			System.out.println("Hello Employees!");
		};
	}

}
