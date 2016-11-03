package com.diesnes.config;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

import com.diesnes.components.CricketMatch;
import com.diesnes.components.Match;
import com.diesnes.components.Team;

@Configuration
@ComponentScan(basePackages = "com.diesnes")
@EnableAspectJAutoProxy
public class ApplicationConfig {
	
    @Autowired
    private List<Team> teams;
    
    //Bean recipe....
    //By default, the bean name will be the same as the method name
    //or can set own bean name with @Bean("customBeanName")
    //http://docs.spring.io/spring-javaconfig/docs/1.0.0.M4/reference/html/ch02s02.html
    //Singleton unless we specify @Scope("prototype")
    @Bean  
    @Scope("prototype")
    public Match randomGame() {
    	System.err.println(">>>>> Called");
    	Team randomA = teams.get(new Random().nextInt(teams.size()));
    	Team randomB = randomA;
    	while(randomA==randomB){
    		randomB = teams.get(new Random().nextInt(teams.size()));
    	}    
        CricketMatch cricketMatch = new CricketMatch(randomA, randomB);
        return cricketMatch;
    }
}
