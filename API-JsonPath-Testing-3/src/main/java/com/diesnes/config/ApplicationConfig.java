package com.diesnes.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.diesnes.components.TeamRepository;
import com.diesnes.components.TeamRepositoryBasicImpl;
import com.diesnes.components.Team;

@Configuration
@ComponentScan(basePackages = "com.diesnes")
public class ApplicationConfig {
	
    @Autowired
    private List<Team> teams;
	    
    //Bean recipe....
    //By default, the bean name will be the same as the method name
    //or can set own bean name with @Bean("customBeanName")
    //http://docs.spring.io/spring-javaconfig/docs/1.0.0.M4/reference/html/ch02s02.html
    //Singleton unless we specify @Scope("prototype")
    @Bean  
    public TeamRepository matchRepositoryImpl() {
    	
    	return new TeamRepositoryBasicImpl(teams);

    }
}
