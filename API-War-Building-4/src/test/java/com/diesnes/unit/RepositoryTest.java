package com.diesnes.unit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.diesnes.components.Team;
import com.diesnes.components.TeamRepository;
import com.diesnes.config.ApplicationConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class) // The configuration
															// context for the
															// test
public class RepositoryTest {
	@Autowired // There is only one Match @Bean defined
	private TeamRepository rep;

	@Autowired // from @ContextConfiguration
	private ApplicationContext ctx;

	@Test
	public void testRepository() throws Exception {

		assertNotNull(rep);

		assertNotNull(rep.retrieveTeams());
		assertEquals(3, rep.retrieveTeams().size());

		Team t = new TestTeam();

		rep.addTeam(t);

		assertEquals(4, rep.retrieveTeams().size());

		rep.deleteTeam(t);

		assertEquals(3, rep.retrieveTeams().size());
	}

	public static class TestTeam implements Team {

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "Test Team";
		}
	}

}
