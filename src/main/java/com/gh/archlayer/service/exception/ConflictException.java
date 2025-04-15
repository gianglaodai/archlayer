package com.gh.archlayer.service.exception;

import java.io.Serial;
import java.util.Map;

public class ConflictException extends ServiceException {
  @Serial private static final long serialVersionUID = -2211279525831146751L;

  protected ConflictException(
      final String message,
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final Throwable cause) {
    super(message, code, params, entityClass, cause);
  }

  @Override
  public ErrorType getErrorType() {
    return ErrorType.CONFLICT;
  }

  public static class DuplicateUidException extends ConflictException {
    @Serial private static final long serialVersionUID = -2055405037333506626L;

    protected DuplicateUidException(
        final String message,
        final String code,
        final Map<String, String> params,
        final Class<?> entityClass,
        final Throwable cause) {
      super(message, code, params, entityClass, cause);
    }
  }

  public static class NotUniqueException extends ConflictException {
    @Serial private static final long serialVersionUID = -3414907193058922361L;

    protected NotUniqueException(
        final String message,
        final String code,
        final Map<String, String> params,
        final Class<?> entityClass,
        final Throwable cause) {
      super(message, code, params, entityClass, cause);
    }
  }

  public static class VersionMismatchException extends ConflictException {
    @Serial private static final long serialVersionUID = -3569663809026959319L;

    protected VersionMismatchException(
        final String message,
        final String code,
        final Map<String, String> params,
        final Class<?> entityClass,
        final Throwable cause) {
      super(message, code, params, entityClass, cause);
    }
  }

  public static class ConcurrentModificationException extends ConflictException {
    @Serial private static final long serialVersionUID = 8556473412424152505L;

    protected ConcurrentModificationException(
        final String message,
        final String code,
        final Map<String, String> params,
        final Class<?> entityClass,
        final Throwable cause) {
      super(message, code, params, entityClass, cause);
    }
  }
}
