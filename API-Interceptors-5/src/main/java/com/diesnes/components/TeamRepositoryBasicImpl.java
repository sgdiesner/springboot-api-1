package com.diesnes.components;

import java.util.ArrayList;
import java.util.List;

//This will be a singleton
public class TeamRepositoryBasicImpl implements TeamRepository {
	
	private List<Team> teams;

	public TeamRepositoryBasicImpl(List<Team> teams) {
		this.teams = teams;
	}

	@Override
	public List<Team> retrieveTeams() {
		//ugly
		return (List<Team>) ((ArrayList<Team>)teams).clone();
	}

	@Override
	public void addTeam(Team t) {
		teams.add(t);
	}

	@Override
	public void deleteTeam(Team t) {
		if(teams.contains(t)){
			teams.remove(t);
		}
	}

	@Override
	public Team findTeam(String name) {
		for(Team t: teams){
			if(t.getName().equalsIgnoreCase(name)){
				return t;
			}
		}
		return null;
	}

}
