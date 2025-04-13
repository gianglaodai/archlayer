package com.gh.archlayer.service.exception;

import java.io.Serial;
import java.util.Map;

public class BadRequestException extends ServiceException {
	@Serial
	private static final long serialVersionUID = -3027475893823165632L;

	protected BadRequestException(final String message, final String code, final Map<String, String> params, final Class<?> entityClass, final Throwable cause) {
		super(message, code, params, entityClass, cause);
	}

	@Override
	public ErrorCode getErrorCode() {
		return ErrorCode.BAD_REQUEST;
	}
}
