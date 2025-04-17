package com.gh.archlayer.service.exception;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

/** Represents an exception that is thrown when a resource is not found. */
public class NotFoundException extends BadEntityException {
  @Serial private static final long serialVersionUID = -7569392120690123232L;

  /** Creates a new instance of NotFoundException. */
  protected NotFoundException(
      final Map<String, Serializable> params, final Class<?> entityClass, final long id) {
    super(
        entityClass,
        Map.of("id", id),
        String.format("%s with id [%s] not found", entityClass.getSimpleName(), id));
  }

  /**
   * {@inheritDoc}
   *
   * @return {@link ErrorType#NOT_FOUND}
   */
  @Override
  public ErrorType getErrorType() {
    return ErrorType.NOT_FOUND;
  }

  @Override
  protected String getErrorKey() {
    return "not_found";
  }
}
