package com.diesnes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.diesnes.components.CricketMatch;
import com.diesnes.components.Match;
import com.diesnes.components.MatchError;
import com.diesnes.components.Result;
import com.diesnes.components.Team;

@RestController
@RequestMapping(value = "/match")
public class MatchController {
	
	@Autowired  //from @ContextConfiguration
	private ApplicationContext ctx;
	
	//The MatchController will be a singleton instance
	//Hence the random match is only injected once
	@Autowired
	private Match randomGame;

	@Autowired
	private List<Team> teams;

	@RequestMapping(method = RequestMethod.GET, value = "/info")
	String info() {
		return "Welcome to the cricket match site";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/random")
	Object playRandomMatch() {

		Team winner = randomGame.playMatch();

		Result result = new Result();
		result.setHome(randomGame.getHomeTeam());
		result.setAway(randomGame.getAwayTeam());
		result.setWinner(winner);
		return result;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/random2")
	Object playRandomMatch2() {
		
		//Get a fresh instance from the context
		Match m = (Match)ctx.getBean("randomGame", Match.class);

		Team winner = m.playMatch();

		Result result = new Result();
		result.setHome(m.getHomeTeam());
		result.setAway(m.getAwayTeam());
		result.setWinner(winner);
		return result;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{hometeam}/verses/{awayteam}")
	Object playMatch(@PathVariable String hometeam, @PathVariable String awayteam) {

		Team th = find(hometeam);

		if (th == null) {
			MatchError e = new MatchError();
			e.setMessage("Home team not known: " + hometeam);
			return e;
		}

		Team ta = find(awayteam);

		if (ta == null) {
			MatchError e = new MatchError();
			e.setMessage("Away team not known: " + awayteam);
			return e;
		}

		CricketMatch match = new CricketMatch(th, ta);

		Team winner = match.playMatch();

		Result result = new Result();
		result.setHome(th);
		result.setAway(ta);
		result.setWinner(winner);
		return result;
	}


	private Team find(String hometeam) {

		for (Team t : teams) {
			if (t.getName().equalsIgnoreCase(hometeam)) {
				return t;
			}
		}
		return null;
	}
}
