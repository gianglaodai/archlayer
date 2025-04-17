package com.gh.archlayer.service.exception;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

/** Represents a conflict exception that occurs when an entity is in an invalid state. */
public class ConflictException extends BadEntityException {
  @Serial private static final long serialVersionUID = -2211279525831146751L;

  /**
   * Constructs a new ConflictException with the specified entity class, parameters, and message.
   */
  public ConflictException(
      final Class<?> entityClass, final Map<String, Serializable> params, final String message) {
    super(entityClass, params, message);
  }

  @Override
  protected String getErrorKey() {
    return "conflict";
  }

  /**
   * {@inheritDoc}
   *
   * @return {@link ErrorType#CONFLICT}
   */
  @Override
  public ErrorType getErrorType() {
    return ErrorType.CONFLICT;
  }

  /** Represents a conflict exception that occurs when a unique identifier is already in use. */
  public static class DuplicateUidException extends ConflictException {
    @Serial private static final long serialVersionUID = -2055405037333506626L;

    /**
     * Constructs a new DuplicateUidException with the specified entity class, parameters, and
     * message.
     */
    protected DuplicateUidException(
        final Class<?> entityClass, final Map<String, Serializable> params, final String message) {
      super(entityClass, params, message);
    }

    @Override
    protected String getErrorKey() {
      return "duplicate_uid";
    }
  }

  /** Represents a conflict exception that occurs when a unique identifier is already in use. */
  public static class NotUniqueException extends ConflictException {
    @Serial private static final long serialVersionUID = -3414907193058922361L;

    /**
     * Constructs a new NotUniqueException with the specified entity class, parameters, and message.
     */
    protected NotUniqueException(
        final Class<?> entityClass, final Map<String, Serializable> params, final String message) {
      super(entityClass, params, message);
    }

    @Override
    protected String getErrorKey() {
      return "not_unique";
    }
  }

  /** Represents a conflict exception that occurs when a version mismatch is detected. */
  public static class VersionMismatchException extends ConflictException {
    @Serial private static final long serialVersionUID = -3569663809026959319L;

    /**
     * Constructs a new VersionMismatchException with the specified entity class, parameters, and
     * message.
     */
    protected VersionMismatchException(
        final Class<?> entityClass, final Map<String, Serializable> params, final String message) {
      super(entityClass, params, message);
    }

    @Override
    protected String getErrorKey() {
      return "version_mismatch";
    }
  }

  /** Represents a conflict exception that occurs when a concurrent modification is detected. */
  public static class ConcurrentModificationException extends ConflictException {
    @Serial private static final long serialVersionUID = 8556473412424152505L;

    /**
     * Constructs a new ConcurrentModificationException with the specified entity class, parameters,
     * and message.
     */
    protected ConcurrentModificationException(
        final Class<?> entityClass, final Map<String, Serializable> params, final String message) {
      super(entityClass, params, message);
    }

    @Override
    protected String getErrorKey() {
      return "concurrent_modification";
    }
  }
}
