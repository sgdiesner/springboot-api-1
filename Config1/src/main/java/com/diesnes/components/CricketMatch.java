package com.diesnes.components;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class CricketMatch implements Match {
	    private Team homeTeam;
	    private Team awayTeam;

	    public CricketMatch() {}

	    public CricketMatch(Team homeTeam, Team awayTeam) {
	        this.homeTeam = homeTeam;
	        this.awayTeam = awayTeam;
	    }

	    @PostConstruct
	    public void startGame() {
	        System.out.println("Playing National Athem");
	    }

	    @PreDestroy
	    public void endGame() {
	        System.out.println("Sending highlights to BBC");
	    }


	    public void setHomeTeam(Team homeTeam) {
	        this.homeTeam = homeTeam;
	    }

	    @Override
	    public Team getHomeTeam() {
	        return homeTeam;
	    }

	    public void setAwayTeam(Team awayTeam) {
	        this.awayTeam = awayTeam;
	    }

	    @Override
	    public Team getAwayTeam() {
	        return awayTeam;
	    }

	    @Override
	    public Team playMatch() {
	        return Math.random() < 0.5 ? getHomeTeam() :
	                getAwayTeam();
	    }

	    @Override
	    public String toString() {
	        return String.format("Game between %s at %s", awayTeam.getName(), homeTeam.getName());
	    }
}
