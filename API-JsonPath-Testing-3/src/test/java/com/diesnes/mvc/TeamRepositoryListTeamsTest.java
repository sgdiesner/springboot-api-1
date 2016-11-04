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
public class TeamRepositoryListTeamsTest {
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
	public void getInfo() throws Exception {
		//helps building a ResultMatcher
		ResultMatcher ok = MockMvcResultMatchers.status().isOk();
		ResultMatcher contentJson = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

		//MockMvcRequestBuilders helps building MockHttpServletRequest
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/t").accept(MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE );
		
		//Body = [{"name":"Cheshire"},{"name":"Lancashire"},{"name":"Staffordshire"}]
		this.mockMvc.perform(builder)
			.andExpect(ok)
			.andExpect(contentJson)
			.andExpect(jsonPath("$", hasSize(3)))
			.andExpect(jsonPath("$[0].name", is("Cheshire")))
			.andExpect(jsonPath("$[1].name", is("Lancashire")))
			.andExpect(jsonPath("$[2].name", is("Staffordshire")))
			.andDo(MockMvcResultHandlers.print());
	}
}
