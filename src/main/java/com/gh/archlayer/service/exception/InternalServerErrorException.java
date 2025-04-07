package com.gh.archlayer.service.exception;

import java.io.Serial;

public class InternalServerErrorException extends ServiceException {
	@Serial
	private static final long serialVersionUID = 7074120338525930310L;

	public InternalServerErrorException(final String message) {
		super(message);
	}

	public InternalServerErrorException(final String message, final Throwable cause) {
		super(message, cause);
	}

	@Override
	public ErrorCode getErrorCode() {
		return ErrorCode.INTERNAL_SERVER_ERROR;
	}
}
