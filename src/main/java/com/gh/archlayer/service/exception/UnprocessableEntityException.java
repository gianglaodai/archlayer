package com.gh.archlayer.service.exception;

import java.io.Serial;

public class UnprocessableEntityException extends ServiceException {
	@Serial
	private static final long serialVersionUID = -2389662250131624860L;

	public UnprocessableEntityException(final String message) {
		super(message);
	}

	public UnprocessableEntityException(final String message, final Throwable cause) {
		super(message, cause);
	}

	@Override
	public ErrorCode getErrorCode() {
		return ErrorCode.UNPROCESSABLE_ENTITY;
	}
}
