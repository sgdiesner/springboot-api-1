package com.diesnes.components;

import org.springframework.stereotype.Component;

@Component
public class Cheshire implements Team {

	@Override
	public String getName() {
		return "Cheshire";
	}
}
