package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	// Custom Exception Handler Area Starts
	
	@ExceptionHandler(SellerException.class)
	public ResponseEntity<ErrorDetails> sellerExceptionHandler(SellerException slre, WebRequest wr){
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), slre.getMessage(), wr.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorDetails> customerNotFoundExceptionHandler(CustomerNotFoundException cnfe, WebRequest wr){
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), cnfe.getMessage(), wr.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<ErrorDetails> customerExceptionHandler(CustomerException ce, WebRequest wr){
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), ce.getMessage(), wr.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.FORBIDDEN);
	}
	
	
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<ErrorDetails> loginExceptionHandler(LoginException le, WebRequest wr){
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), le.getMessage(), wr.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.FORBIDDEN);
	}
	
	// Custom Exception Handler Area Ends
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> noHandlerFoundExceptionHandler(NoHandlerFoundException nhfe, WebRequest wr){
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), nhfe.getMessage(), wr.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException manv, WebRequest wr){
		String message = manv.getBindingResult().getFieldError().getDefaultMessage();
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), message, wr.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.FORBIDDEN);
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> exceptionHandler(Exception e, WebRequest wr){
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), e.getMessage(), wr.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
}
