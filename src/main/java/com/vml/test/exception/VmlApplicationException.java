package com.vml.test.exception;

public class VmlApplicationException extends Exception {

	private static final long serialVersionUID = 1L;

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
