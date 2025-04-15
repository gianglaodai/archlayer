package com.gh.archlayer.service.exception;

import java.io.Serial;
import java.util.Map;

public class InternalServerException extends ServiceException {
  @Serial private static final long serialVersionUID = 7074120338525930310L;

  protected InternalServerException(
      final String message,
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final Throwable cause) {
    super(message, "INTERNAL_SERVER_ERROR", params, entityClass, cause);
  }

  @Override
  public ErrorType getErrorType() {
    return ErrorType.INTERNAL_SERVER_ERROR;
  }
}
