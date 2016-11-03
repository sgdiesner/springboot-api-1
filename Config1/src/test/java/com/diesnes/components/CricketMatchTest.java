package com.diesnes.components;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.diesnes.config.ApplicationConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)  //The configuration context for the test
public class CricketMatchTest {
	@Autowired //There is only one Match @Bean defined
	private Match game;

	@Autowired  //from @ContextConfiguration
	private ApplicationContext ctx;

	@Test
	public void testPlayMatch() throws Exception {
		String home = game.getHomeTeam().getName();
		String away = game.getAwayTeam().getName();

		assertNotEquals(home, away);
		
		Team winner = game.playMatch();
		assertTrue(winner==game.getHomeTeam() || winner==game.getAwayTeam());

	}

	@Test
	public void testGetAndSetHomeTeam() throws Exception {
		Team cheshire = ctx.getBean("cheshire", Team.class);
		game.setHomeTeam(cheshire);
		assertEquals(cheshire.getName(), game.getHomeTeam().getName());
	}
}
