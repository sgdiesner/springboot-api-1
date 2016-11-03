package com.diesnes.components;

public class TeamTemplate implements Team {
	
	private String name;
	
	public TeamTemplate(String name){
		this.name = name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
