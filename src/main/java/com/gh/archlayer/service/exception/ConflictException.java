package com.gh.archlayer.service.exception;

import java.io.Serial;

public class ConflictException extends ServiceException{
	@Serial
	private static final long serialVersionUID = -2211279525831146751L;

	public ConflictException(final String message) {
		super(message);
	}

	public ConflictException(final String message, final Throwable cause) {
		super(message, cause);
	}

	@Override
	public ErrorCode getErrorCode() {
		return ErrorCode.CONFLICT;
	}
}
