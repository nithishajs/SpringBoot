package com.b.exception;

public class NotFound extends RuntimeException {
	
	String msg;

	public NotFound(String message) {
		super(message);
		this.msg=message;
		// TODO Auto-generated constructor stub
	}
	
	

}
