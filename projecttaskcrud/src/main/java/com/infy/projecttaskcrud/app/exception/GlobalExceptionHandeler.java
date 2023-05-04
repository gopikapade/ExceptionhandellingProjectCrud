package com.infy.projecttaskcrud.app.exception;



import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandeler {
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ApiError productNotFoundException(ProductNotFoundException exception,HttpServletRequest request)
	{
		ApiError error=new ApiError(HttpStatus.NOT_FOUND.value(),exception.getMessage(),new Date(), HttpStatus.NOT_FOUND, request.getRequestURI());
		
		return error;
	}

}
