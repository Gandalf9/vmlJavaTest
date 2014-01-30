package com.vml.test.exception;

public class VmlApplicationException extends Exception {

	public VmlApplicationException() {
		super();
	}
	
	public VmlApplicationException(String s) {
		super(s);
	}
	
	public VmlApplicationException(String s, Throwable cause) {
		super(s, cause);
	}
}
