package com.management.hostel.exception;

public class UserAlreadyPresentException extends RuntimeException {
	public UserAlreadyPresentException(String message) { super(message); }
}
