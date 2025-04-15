package com.gh.archlayer.service.exception;

import java.io.Serial;
import java.util.Map;

public class ForbiddenException extends ServiceException {
  @Serial private static final long serialVersionUID = 5285702989155541431L;

  protected ForbiddenException(
      final String message,
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final Throwable cause) {
    super(message, code, params, entityClass, cause);
  }

  @Override
  public ErrorType getErrorType() {
    return ErrorType.FORBIDDEN;
  }

  public static class ResourceLockedException extends ForbiddenException {
    @Serial private static final long serialVersionUID = 2676941833571058655L;

    public ResourceLockedException(
        final String message,
        final String code,
        final Map<String, String> params,
        final Class<?> entityClass,
        final Throwable cause) {
      super(message, code, params, entityClass, cause);
    }
  }

  public static class OwnershipViolationException extends ForbiddenException {
    @Serial private static final long serialVersionUID = 955369733172629613L;

    public OwnershipViolationException(
        final String message,
        final String code,
        final Map<String, String> params,
        final Class<?> entityClass,
        final Throwable cause) {
      super(message, code, params, entityClass, cause);
    }
  }
}
