package com.gh.archlayer.service.validation;

import java.io.Serializable;
import java.util.Map;

/**
 * Represents a validation error with a field, code, and optional parameters.
 *
 * @param field the field that caused the validation error
 * @param code the error code for the validation error
 * @param params optional parameters for the validation error
 */
public record ValidationError(String field, String code, Map<String, Serializable> params) {

  /**
   * Constructs a new ValidationError with the given field and code.
   *
   * @param field the field that caused the validation error
   * @param code the error code for the validation error
   */
  public ValidationError(final String field, final String code) {
    this(field, code, Map.of());
  }
}
