package com.oto.exception;

public class NotFoundException extends RuntimeException{
	
	String msg;


	public NotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
		this.msg=message;
	}
	
	

}
