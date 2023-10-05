package com.m.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorResponse {
	
	int code;
	String msg;
	
	@Override
	public String toString() {
		return "ErrorResponse [code=" + code + ", msg=" + msg + "]";
	}
	

}
