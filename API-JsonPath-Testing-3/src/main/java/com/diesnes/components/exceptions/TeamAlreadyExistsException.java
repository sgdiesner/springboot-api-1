package com.diesnes.components.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT, reason="Team already exists")  // 409 Conflict
public class TeamAlreadyExistsException extends RuntimeException {

	/**
	 * Unique ID for Serialized object
	 */
	private static final long serialVersionUID = 4657491283614455649L;

	public TeamAlreadyExistsException(String msg) {
		super(msg);
	}

	public TeamAlreadyExistsException(String msg, Throwable t) {
		super(msg, t);
	}
	
}
