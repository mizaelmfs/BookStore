package com.mizael.bookstore.exception;

import static com.mizael.bookstore.exception.ExceptionConstants.SECURITY_EXCEPTION;

public class SecurityException extends GenericException {

	private static final long serialVersionUID = 201606062325L;

	public SecurityException() {
		super(SECURITY_EXCEPTION);
	}

}
