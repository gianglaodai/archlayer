package com.gh.archlayer.service.exception;

import java.io.Serial;

public class UnauthorizedException extends ServiceException{
	@Serial
	private static final long serialVersionUID = 6165663835362396871L;

	public UnauthorizedException(final String message) {
		super(message);
	}

	public UnauthorizedException(final String message, final Throwable cause) {
		super(message, cause);
	}

	@Override
	public ErrorCode getErrorCode() {
		return ErrorCode.UNAUTHORIZED;
	}
}
