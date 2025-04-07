package com.gh.archlayer.service.exception;

public enum ErrorCode {
	BAD_REQUEST(400),
	UNAUTHORIZED(401),
	FORBIDDEN(403),
	NOT_FOUND(404),
	CONFLICT(409),
	UNPROCESSABLE_ENTITY(422),
	INTERNAL_SERVER_ERROR(500);

	private final int httpStatus;

	ErrorCode(final int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public int getHttpStatus() {
		return httpStatus;
	}
}
