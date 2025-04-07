package com.gh.archlayer.service.exception;

import java.io.Serial;

public class ForbiddenException extends ServiceException {
	@Serial
	private static final long serialVersionUID = 5285702989155541431L;

	public ForbiddenException(String message) {
		super(message);
	}

	public ForbiddenException(String message, Throwable cause) {
		super(message, cause);
	}

	@Override
	public ErrorCode getErrorCode() {
		return ErrorCode.FORBIDDEN;
	}
}
