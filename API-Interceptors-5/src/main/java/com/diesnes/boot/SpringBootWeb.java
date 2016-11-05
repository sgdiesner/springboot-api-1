package com.diesnes.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan( basePackages = "com.diesnes")
@EnableAutoConfiguration
public class SpringBootWeb extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootWeb.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootWeb.class, args);
    }

}