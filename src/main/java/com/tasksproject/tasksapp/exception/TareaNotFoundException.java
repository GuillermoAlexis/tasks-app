package com.tasksproject.tasksapp.exception;

public class TareaNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TareaNotFoundException(String message) {
		super(message);
	}

	public TareaNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
