package com.project.apiperson.service.exceptions;

public class DataIntegrityViolationException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public DataIntegrityViolationException(String msg) {
		super(msg);
	}

}
