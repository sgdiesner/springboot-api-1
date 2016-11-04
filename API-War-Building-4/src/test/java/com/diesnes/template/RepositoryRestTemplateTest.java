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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

//http://howtodoinjava.com/spring/spring-restful/spring-restful-client-resttemplate-example/
public class RepositoryRestTemplateTest {
	final String uriAll = "http://localhost:8080/teams";
	final String uriAddDelete = "http://localhost:8080/teams/team/{name}";

	//@Test
	public void retrieveAll() {
		RestTemplate restTemplate = new RestTemplate();
		List result = restTemplate.getForObject(uriAll, List.class);

		assertTrue(result.size() > 3);
	}

	//@Test
	public void add() {
		RestTemplate restTemplate = new RestTemplate();
		List result = restTemplate.getForObject(uriAll, List.class);

		int beforeSize = result.size();

		String newName = "ABC" + new Random().nextInt();
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("name", newName);

		restTemplate = new RestTemplate();
		restTemplate.put(uriAddDelete, null, params);

		result = restTemplate.getForObject(uriAll, List.class);

		int afterSize = result.size();

		assertEquals(beforeSize + 1, afterSize);

	}

}