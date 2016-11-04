package com.diesnes.mvc;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

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
public class MockMVC1Test {

	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
		this.mockMvc = builder.build();
	}

	@Test
	public void testMyMvcController() throws Exception {
		//helps building a ResultMatcher
		ResultMatcher ok = MockMvcResultMatchers.status().isOk();
		ResultMatcher msg = MockMvcResultMatchers.content().string(Matchers.containsString("Welcome to the cricket match site"));

		//MockMvcRequestBuilders helps building MockHttpServletRequest
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/match/info");
		this.mockMvc.perform(builder).andExpect(ok).andExpect(msg);
	}
}
