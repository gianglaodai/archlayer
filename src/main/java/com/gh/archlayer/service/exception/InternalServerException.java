package com.gh.archlayer.service.exception;

import java.io.Serial;
import java.util.Map;

/** Represents an exception that is thrown when an internal server error occurs. */
public class InternalServerException extends BaseServiceException {
  @Serial private static final long serialVersionUID = 7074120338525930310L;

  /** Creates a new InternalServerException with the specified message. */
  public InternalServerException(final String message) {
    super("internal_server_error", Map.of(), message);
  }

  /** Creates a new InternalServerException with the specified message and cause. */
  public InternalServerException(final String message, final Throwable cause) {
    this(message);
    initCause(cause);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@link ErrorType#INTERNAL_SERVER_ERROR}
   */
  @Override
  public ErrorType getErrorType() {
    return ErrorType.INTERNAL_SERVER_ERROR;
  }
}
