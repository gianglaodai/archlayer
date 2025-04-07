package com.gh.archlayer.service.exception;

import java.io.Serial;

public class NotFoundException extends ServiceException {
	@Serial
	private static final long serialVersionUID = -7569392120690123232L;

	public NotFoundException(final String message) {
		super(message);
	}

	public NotFoundException(final String message, final Throwable cause) {
		super(message, cause);
	}

	@Override
	public ErrorCode getErrorCode() {
		return ErrorCode.NOT_FOUND;
	}
}
