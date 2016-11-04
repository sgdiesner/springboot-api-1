package com.diesnes.template;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.diesnes.components.Team;

//http://howtodoinjava.com/spring/spring-restful/spring-restful-client-resttemplate-example/
public class DuplicateTeamCreateTest {
	final String uriAll = "http://localhost:8080/teams";
	final String uriAddDelete = "http://localhost:8080/teams/team/{name}";

	//@Test
	public void addDuplicate() {
		RestTemplate restTemplate = new RestTemplate();
		MyTeam[] result = restTemplate.getForObject(uriAll, MyTeam[].class);

		String newName = result[0].getName();

		Map<String, String> params = new HashMap<String, String>();
		params.put("name", newName);

		restTemplate = new RestTemplate();
		try{
			restTemplate.put(uriAddDelete, null, params);
		}catch (HttpClientErrorException hcee){
			assertEquals(hcee.getStatusCode(), HttpStatus.CONFLICT);
		}
	}

	//Has to be a concrete class, not an interface
	static class MyTeam {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

}