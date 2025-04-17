package com.gh.archlayer.service.exception;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

/** Represents a forbidden exception that occurs when an entity is in an invalid state. */
public class ForbiddenException extends BadEntityException {
  @Serial private static final long serialVersionUID = 5285702989155541431L;

  /**
   * Constructs a new ForbiddenException with the specified entity class, parameters, and message.
   */
  public ForbiddenException(
      final Class<?> entityClass, final Map<String, Serializable> params, final String message) {
    super(entityClass, params, message);
  }

  @Override
  protected String getErrorKey() {
    return "forbidden";
  }

  /**
   * {@inheritDoc}
   *
   * @return {@link ErrorType#FORBIDDEN}
   */
  @Override
  public ErrorType getErrorType() {
    return ErrorType.FORBIDDEN;
  }

  /** Represents a resource locked exception that occurs when an entity is in an invalid state. */
  public static class ResourceLockedException extends ForbiddenException {
    @Serial private static final long serialVersionUID = 2676941833571058655L;

    /** Constructs a new ResourceLockedException with the specified entity class and id. */
    public ResourceLockedException(final Class<?> entityClass, final long id) {
      super(
          entityClass,
          Map.of("id", String.valueOf(id)),
          String.format("%s with id [%s] is currently locked", entityClass.getSimpleName(), id));
    }

    @Override
    protected String getErrorKey() {
      return "resource_locked";
    }
  }

  /**
   * Represents an ownership violation exception that occurs when an entity is in an invalid state.
   */
  public static class OwnershipViolationException extends ForbiddenException {
    @Serial private static final long serialVersionUID = 955369733172629613L;

    /**
     * Constructs a new OwnershipViolationException with the specified entity class, resource id,
     * and owner id.
     */
    public OwnershipViolationException(
        final Class<?> entityClass, final long resourceId, final long ownerId) {
      super(
          entityClass,
          Map.of("resourceId", String.valueOf(resourceId), "ownerId", String.valueOf(ownerId)),
          String.format(
              "You do not have permission to access [%s] with id [%d] owned by [%d]",
              entityClass.getSimpleName(), resourceId, ownerId));
    }

    @Override
    protected String getErrorKey() {
      return "ownership_violation";
    }
  }
}
