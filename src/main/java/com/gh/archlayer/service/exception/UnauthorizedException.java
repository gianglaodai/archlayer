package com.gh.archlayer.service.exception;

import java.io.Serial;
import java.util.Map;

/** Represents an exception that is thrown when an unauthorized access is attempted. */
public class UnauthorizedException extends BaseServiceException {
  @Serial private static final long serialVersionUID = 6165663835362396871L;

  /** Constructs a new UnauthorizedException. */
  protected UnauthorizedException() {
    super("unauthorized", Map.of(), "Unauthorized access");
  }

  /**
   * {@inheritDoc}
   *
   * @return {@link ErrorType#UNAUTHORIZED}
   */
  @Override
  public ErrorType getErrorType() {
    return ErrorType.UNAUTHORIZED;
  }
}
