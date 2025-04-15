package com.gh.archlayer.service.exception;

public enum ErrorType {
  BAD_REQUEST(400),
  UNAUTHORIZED(401),
  FORBIDDEN(403),
  NOT_FOUND(404),
  CONFLICT(409),
  UNPROCESSABLE_ENTITY(422),
  INTERNAL_SERVER_ERROR(500);

  private final int httpStatus;

  ErrorType(final int httpStatus) {
    this.httpStatus = httpStatus;
  }

  public int getHttpStatus() {
    return httpStatus;
  }
}
