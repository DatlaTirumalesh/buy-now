package com.aero.insure.payment.service.exception;

public class NoPaymentsFound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoPaymentsFound(String message) {
		super(message);
	}

}
