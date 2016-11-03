package com.diesnes.components;

public interface Match {
    void setHomeTeam(Team team);
    Team getHomeTeam();
    void setAwayTeam(Team team);
    Team getAwayTeam();
    Team playMatch();
}