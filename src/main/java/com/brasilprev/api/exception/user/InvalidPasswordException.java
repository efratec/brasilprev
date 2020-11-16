package com.brasilprev.api.exception.user;

public class InvalidPasswordException extends Exception {
	public InvalidPasswordException() {
		super("Invalid Password!");
	}
}
