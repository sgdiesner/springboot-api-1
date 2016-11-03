package com.diesnes.components;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

//http://howtodoinjava.com/spring/spring-restful/spring-restful-client-resttemplate-example/
public class CricketMatchRestTemplateTest {
	final String uriRandom = "http://localhost:8080/match/random";
	final String uriHomeAway = "http://localhost:8080/match/{hometeam}/verses/{awayteam}";
	@Test
	public void directCall() {
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uriRandom, String.class);

		System.out.println(result);
	}
	

	@Test
	public void directCallWithAccessToResponseObject() {
		   RestTemplate restTemplate = new RestTemplate();
		     
		    HttpHeaders headers = new HttpHeaders();
		    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		     
		    ResponseEntity<String> result = restTemplate.exchange(uriRandom, HttpMethod.GET, entity, String.class);	    
		     
		    System.out.println(result);
		    System.out.println(result.getStatusCodeValue());
		    System.out.println(result.getBody());
		    System.out.println(result.getHeaders());
	}
	
	@Test
	public void passParams(){
	     
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("hometeam", "cheshire");
	    params.put("awayteam", "staffordshire");
	     
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uriHomeAway, String.class, params);
	     
	    System.out.println(result);	
		
		
	}
}