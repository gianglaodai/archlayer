package com.gh.archlayer.service.exception;

import com.gh.archlayer.service.validation.ValidationError;
import java.io.Serial;
import java.util.List;
import java.util.Map;

/** Represents a validation exception that occurs when an entity is in an invalid state. */
public class ValidationException extends BaseServiceException implements ServiceException {

  @Serial private static final long serialVersionUID = 7130623270882187020L;
  private final List<ValidationError> errors;

  /** Constructs a new ValidationException with the specified list of validation errors. */
  protected ValidationException(final List<ValidationError> errors) {
    super("validation.failed", Map.of("errorCount", errors.size()), "Validation failed.");
    this.errors = List.copyOf(errors);
  }

  /**
   * Returns the list of {@link ValidationError}s that caused this exception.
   *
   * @return a list of validation errors
   */
  public List<ValidationError> getErrors() {
    return errors;
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
}
