package com.gh.archlayer.service.exception;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

/**
 * Represents an exception that is thrown when a bad request is made. This exception is used to
 * handle invalid or malformed requests.
 */
public class BadRequestException extends BaseServiceException {
  @Serial private static final long serialVersionUID = -3027475893823165632L;

  /**
   * Constructs a new BadRequestException with the specified error key, parameters, and message.
   *
   * @param errorKey the error key associated with this exception
   * @param params the parameters associated with this exception
   * @param message the detail message of this exception
   */
  protected BadRequestException(
      final String errorKey, final Map<String, Serializable> params, final String message) {
    super(errorKey, params, message);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@link ErrorType#BAD_REQUEST}
   */
  @Override
  public ErrorType getErrorType() {
    return ErrorType.BAD_REQUEST;
  }

  @Override
  public String getCode() {
    return "bad_request." + getErrorKey();
  }
}
