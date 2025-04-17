package com.gh.archlayer.service.exception;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

/** Represents an exception that occurs when an entity is in an invalid state. */
public abstract class BadEntityException extends RuntimeException implements ServiceException {
  @Serial private static final long serialVersionUID = 8757058442968326198L;
  private final Map<String, Serializable> params;
  private final Class<?> entityClass;

  /**
   * Constructs a new BadEntityException with the given entity class, parameters, and message.
   *
   * @param entityClass the class of the entity that caused this exception
   * @param params the parameters associated with this exception
   * @param message the message describing this exception
   */
  protected BadEntityException(
      final Class<?> entityClass, final Map<String, Serializable> params, final String message) {
    super(message);
    this.entityClass = entityClass;
    this.params = Map.copyOf(params);
  }

  /**
   * Gets the error key that is associated with this exception.
   *
   * @return the error key associated with this exception
   */
  protected abstract String getErrorKey();

  /**
   * Retrieves the code representing the entity class associated with this exception. The code is
   * the simple name of the entity class converted to lowercase.
   *
   * @return the entity code in lowercase
   */
  protected String getEntityCode() {
    return entityClass.getSimpleName().toLowerCase();
  }

  @Override
  public String getCode() {
    return getEntityCode() + "." + getErrorKey();
  }

  /**
   * Retrieves a copy of the parameters associated with this exception.
   *
   * @return a map containing the parameters associated with this exception
   */
  @Override
  public Map<String, Serializable> getParams() {
    return Map.copyOf(params);
  }

  /**
   * Retrieves the class of the entity associated with this exception.
   *
   * @return the class of the entity
   */
  public Class<?> getEntityClass() {
    return entityClass;
  }
}
