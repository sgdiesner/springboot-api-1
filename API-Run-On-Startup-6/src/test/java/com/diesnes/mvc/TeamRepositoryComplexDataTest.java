package com.diesnes.mvc;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.mockito.Mockito.*;

import static org.hamcrest.Matchers.*;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import com.diesnes.config.ApplicationConfig;

//
//http://www.programcreek.com/java-api-examples/index.php?api=org.springframework.test.web.servlet.result.MockMvcResultMatchers
//

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration // specify that WebApplicationContext should be loaded for
						// the test
@ContextConfiguration(classes = ApplicationConfig.class) // specify how to load
															// spring bean
															// metadata
public class TeamRepositoryComplexDataTest {
	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
		this.mockMvc = builder.build();
	}

	@Test
	//https://www.javacodegeeks.com/2013/08/unit-testing-of-spring-mvc-controllers-rest-api.html
	//http://www.baeldung.com/guide-to-jayway-jsonpath
	public void getInfo() throws Exception {
		//helps building a ResultMatcher
		ResultMatcher ok = MockMvcResultMatchers.status().isOk();
		ResultMatcher contentJson = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

		//MockMvcRequestBuilders helps building MockHttpServletRequest
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/teams/complex").accept(MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE );
		
		//{"identifier":23,"names":["a","b"],"data":[{"account":-1445482239702780480,"balances":[236,68]},{"account":-7775088287047268748,"balances":[442,263]},{"account":4963458309579810235,"balances":[432,405]}]}

		/*
			{
			  "identifier": 23,
			  "names": [
			    "a",
			    "b"
			  ],
			  "data": [
			    {
			      "account": -1.4454822397028e+18,
			      "balances": [
			        236,
			        68
			      ]
			    },
			    {
			      "account": -7.7750882870473e+18,
			      "balances": [
			        442,
			        263
			      ]
			    },
			    {
			      "account": 4.9634583095798e+18,
			      "balances": [
			        432,
			        405
			      ]
			    }
			  ]
			}
		 */
		this.mockMvc.perform(builder)
			.andExpect(ok)
			.andExpect(contentJson)
			.andExpect(jsonPath("$.identifier", is(23)))
			.andExpect(jsonPath("$.names[0]", is("a")))
			.andExpect(jsonPath("$.names[1]", is("b")))
			.andExpect(jsonPath("$.data", hasSize(3)))
			.andExpect(jsonPath("$.data[0].account", not(0) ))
			.andExpect(jsonPath("$.data[0].balances", hasSize(2)))
			.andDo(MockMvcResultHandlers.print());
	}
}
