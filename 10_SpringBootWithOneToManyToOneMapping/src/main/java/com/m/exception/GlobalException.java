package com.m.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(value=NotFoundException.class)
	@ResponseBody
	public ErrorResponse NotFound(NotFoundException n) {
		ErrorResponse er = new ErrorResponse();
		er.setCode(HttpStatus.CONFLICT.value());
		er.setMsg(n.getMessage());
		return er;
	}

}
