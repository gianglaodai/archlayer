package com.gh.archlayer.service.exception;

import java.io.Serial;
import java.util.Map;

public class UnauthorizedException extends ServiceException{
	@Serial
	private static final long serialVersionUID = 6165663835362396871L;

	protected UnauthorizedException(final String message, final String code, final Map<String, String> params, final Class<?> entityClass, final Throwable cause) {
		super(message, code, params, entityClass, cause);
	}

	@Override
	public ErrorCode getErrorCode() {
		return ErrorCode.UNAUTHORIZED;
	}
}
