package com.diesnes.components;

import java.util.List;

public interface TeamRepository {

	public List<Team> retrieveTeams();
	
	public void addTeam(Team t);
	
	public void deleteTeam(Team t);
	
	public Team findTeam(String t);
}
