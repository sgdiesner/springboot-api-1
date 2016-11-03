package com.diesnes.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication  its ComponentScan will only start at this package and downwards
@Configuration
@ComponentScan( basePackages = "com.diesnes")
@EnableAutoConfiguration
class SpringBootApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp.class, args);
	}
}
