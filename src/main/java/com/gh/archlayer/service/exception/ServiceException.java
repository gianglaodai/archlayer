package com.gh.archlayer.service.exception;

import java.io.Serial;

public abstract class ServiceException extends RuntimeException {
	@Serial
	private static final long serialVersionUID = 8757058442968326198L;
	public ServiceException(final String message) {
		super(message);
	}

	public ServiceException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public abstract ErrorCode getErrorCode();
}
