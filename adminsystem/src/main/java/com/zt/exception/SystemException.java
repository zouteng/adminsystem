package com.zt.exception;

public class SystemException extends RuntimeException {
	public SystemException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public SystemException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public SystemException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SystemException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
}
