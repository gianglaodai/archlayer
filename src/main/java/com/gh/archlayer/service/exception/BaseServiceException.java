package com.gh.archlayer.service.exception;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

/**
 * Represents a base service exception that provides a common implementation for service-related
 * exceptions. This class extends RuntimeException and implements the ServiceException interface.
 */
public abstract class BaseServiceException extends RuntimeException implements ServiceException {
  @Serial private static final long serialVersionUID = 1004204973643383417L;

  private final Map<String, Serializable> params;
  private final String errorKey;

  /**
   * Constructs a new BaseServiceException with the specified error key, parameters, and message.
   */
  public BaseServiceException(
      final String errorKey, final Map<String, Serializable> params, final String message) {
    super(message);
    this.errorKey = errorKey;
    this.params = Map.copyOf(params);
  }

  @Override
  public Map<String, Serializable> getParams() {
    return Map.copyOf(params);
  }

  @Override
  public String getCode() {
    return errorKey;
  }

  /**
   * Retrieves the error key associated with this exception. The error key is a string that uniquely
   * identifies the error type within the context of the application.
   *
   * @return the error key associated with this exception
   */
  protected String getErrorKey() {
    return errorKey;
  }
}
