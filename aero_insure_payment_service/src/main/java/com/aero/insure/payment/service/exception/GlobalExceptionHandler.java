package com.aero.insure.payment.service.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(PaymentAlreadyDoneException.class)
	public ResponseEntity<ErrorResponse> handlePaymentAlreadyDone(
			PaymentAlreadyDoneException pe, HttpServletRequest request) {
		ErrorResponse error = new ErrorResponse ( 
				LocalDateTime.now(),
				HttpStatus.CONFLICT.value(),
				"Payment Already Done",
				pe.getMessage(),
				request.getRequestURI()
				);

				return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoPaymentsFound.class)
	public ResponseEntity<ErrorResponse> handleNoPaymentsFound(
			NoPaymentsFound pe, HttpServletRequest request) {
		ErrorResponse error = new ErrorResponse ( 
				LocalDateTime.now(),
				HttpStatus.CONFLICT.value(),
				"No Payments Found",
				pe.getMessage(),
				request.getRequestURI()
				);

				return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	
}
