package com.brasilprev.api.exception.user;

public class UserDoesNotExistException extends Exception {
	public UserDoesNotExistException() {
		super("User Not Found!");
	}
}
