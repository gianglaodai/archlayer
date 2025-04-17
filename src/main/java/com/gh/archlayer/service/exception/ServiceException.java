package com.gh.archlayer.service.exception;

import java.io.Serializable;
import java.util.Map;

/**
 * This interface represents a service exception, which is an exception that occurs during the
 * execution of a service. It provides methods for getting the code and parameters associated with
 * the exception, as well as the error type.
 */
public interface ServiceException {
  /**
   * Gets the code associated with this exception. The code is a string that uniquely identifies the
   * type of exception that has occurred.
   *
   * @return the code associated with this exception
   */
  String getCode();

  /**
   * Gets the parameters associated with this exception. The returned map is a read-only view of the
   * parameters, and is guaranteed to be non-null.
   *
   * @return a copy of the parameters associated with this exception
   */
  Map<String, Serializable> getParams();

  /**
   * Gets the error type of this exception.
   *
   * @return the error type of this exception
   */
  ErrorType getErrorType();
}
