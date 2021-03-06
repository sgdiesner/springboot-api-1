package com.diesnes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.diesnes.components.RepositoryResult;
import com.diesnes.components.Team;
import com.diesnes.components.TeamRepository;
import com.diesnes.components.TeamTemplate;
import com.diesnes.components.exceptions.TeamAlreadyExistsException;

@RestController
@RequestMapping(value = "/teams")
public class TeamRepositoryController {
	
	@Autowired  //from @ContextConfiguration
	private ApplicationContext ctx;
	
	@Autowired  //This should be the singleton bean as in ApplicationConfig
	private TeamRepository repository;
	
	@RequestMapping(value = "/info")
	public String info() {
		return "{\"message\": \"Welcome to the cricket match site\"}";
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Team [] retrieveListOfTeamsJson() {
		return repository.retrieveTeams().toArray(new Team[]{});
	}
	
	@RequestMapping(value = "/team/{team}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
	public RepositoryResult deleteTeam(@PathVariable String team) {
		Team t = repository.findTeam(team);
		if(t==null){
			return new RepositoryResult("Team " + team + " not found");
		}
		
		repository.deleteTeam(t); 
		
		return new RepositoryResult("Team " + team + " deleted");
	}
	
	@RequestMapping(value = "/team/{team}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
	public ResponseEntity<String> addTeam(@PathVariable String team) {
		Team t = repository.findTeam(team);
		if(t!=null){
			throw new TeamAlreadyExistsException("Team " + team + " already exists");
		}
		
		repository.addTeam(new TeamTemplate(team));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(null);  //	201
	}	
	
	
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.ALL_VALUE)
	public List<Team> retrieveListOfTeamsXml() {
		return repository.retrieveTeams();
	}
}
