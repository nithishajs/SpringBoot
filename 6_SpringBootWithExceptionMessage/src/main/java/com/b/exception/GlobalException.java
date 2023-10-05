package com.b.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalException {
	
	
	@ExceptionHandler(value=NotFound.class)
	@ResponseBody
	public ErrorResponse notfound(NotFound n) {
		ErrorResponse er = new ErrorResponse();
		
		er.setCode(HttpStatus.CONFLICT.value());
		er.setMsg(n.getMessage());
		
		return er;
		
	}

}
