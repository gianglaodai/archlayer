package com.gh.archlayer.service.exception;

import java.io.Serial;

public class BadRequestException extends ServiceException {
	@Serial
	private static final long serialVersionUID = -3027475893823165632L;

	public BadRequestException(final String message) {
		super(message);
	}

	public BadRequestException(final String message, final Throwable cause) {
		super(message, cause);
	}

	@Override
	public ErrorCode getErrorCode() {
		return ErrorCode.BAD_REQUEST;
	}
}
