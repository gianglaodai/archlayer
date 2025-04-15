package com.gh.archlayer.service.exception;

import java.io.Serial;
import java.util.Map;

public class NotFoundException extends ServiceException {
  @Serial private static final long serialVersionUID = -7569392120690123232L;

  protected NotFoundException(
      final String message,
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final Throwable cause) {
    super(message, code, params, entityClass, cause);
  }

  @Override
  public ErrorType getErrorType() {
    return ErrorType.NOT_FOUND;
  }
}
