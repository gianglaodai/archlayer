package com.gh.archlayer.service.validation;

import java.time.Instant;
import java.util.Map;

/** This class provides methods for building validation errors. */
public class ValidationErrors {

  /**
   * Build a {@link ValidationError} for a length constraint violation.
   *
   * @param field the field name
   * @param min the minimum length
   * @param max the maximum length
   * @return a {@link ValidationError} with code "length.invalid" and parameters "min" and "max"
   */
  public static ValidationError buildLengthError(final String field, final int min, final int max) {
    return new ValidationError(field, "length.invalid", Map.of("min", min, "max", max));
  }

  /**
   * Build a {@link ValidationError} for a too short length constraint violation.
   *
   * @param field the field name
   * @param min the minimum length
   * @return a {@link ValidationError} with code "length.too_short" and parameter "min"
   */
  public static ValidationError buildLengthTooShortError(final String field, final int min) {
    return new ValidationError(field, "length.too_short", Map.of("min", min));
  }

  /**
   * Build a {@link ValidationError} for a too long length constraint violation.
   *
   * @param field the field name
   * @param max the maximum length
   * @return a {@link ValidationError} with code "length.too_long" and parameter "max"
   */
  public static ValidationError buildLengthTooLongError(final String field, final int max) {
    return new ValidationError(field, "length.too_long", Map.of("max", max));
  }

  /**
   * Build a {@link ValidationError} for a range constraint violation.
   *
   * @param field the field name
   * @param min the minimum value
   * @param max the maximum value
   * @return a {@link ValidationError} with code "range.invalid" and parameters "min" and "max"
   */
  public static ValidationError buildRangeError(final String field, final int min, final int max) {
    return new ValidationError(field, "range.invalid", Map.of("min", min, "max", max));
  }

  /**
   * Build a {@link ValidationError} for a range constraint violation where the value is too small.
   *
   * @param field the field name
   * @param min the minimum allowable value
   * @return a {@link ValidationError} with code "range.too_small" and parameter "min"
   */
  public static ValidationError buildRangeTooSmallError(final String field, final int min) {
    return new ValidationError(field, "range.too_small", Map.of("min", min));
  }

  /**
   * Build a {@link ValidationError} for a range constraint violation where the value is too large.
   *
   * @param field the field name
   * @param max the maximum allowable value
   * @return a {@link ValidationError} with code "range.too_large" and parameter "max"
   */
  public static ValidationError buildRangeTooLargeError(final String field, final int max) {
    return new ValidationError(field, "range.too_large", Map.of("max", max));
  }

  /**
   * Build a {@link ValidationError} for a required field constraint violation.
   *
   * @param field the field name
   * @return a {@link ValidationError} with code "required"
   */
  public static ValidationError buildRequiredError(final String field) {
    return new ValidationError(field, "required");
  }

  /**
   * Build a {@link ValidationError} for a format constraint violation.
   *
   * @param field the field name
   * @param pattern the expected format pattern
   * @return a {@link ValidationError} with code "format.invalid" and parameter "pattern"
   */
  public static ValidationError buildFormatError(final String field, final String pattern) {
    return new ValidationError(field, "format.invalid", Map.of("pattern", pattern));
  }

  /**
   * Build a {@link ValidationError} for a duplicate field constraint violation.
   *
   * @param field the field name
   * @return a {@link ValidationError} with code "duplicate"
   */
  public static ValidationError buildDuplicateError(final String field) {
    return new ValidationError(field, "duplicate");
  }

  /**
   * Build a {@link ValidationError} for a date constraint violation where the date is not in the
   * future.
   *
   * @param field the field name
   * @param date the date value that is not in the future
   * @return a {@link ValidationError} with code "date.not_in_future" and parameter "date"
   */
  public static ValidationError buildDateNotInFutureError(final String field, final Instant date) {
    return new ValidationError(field, "date.not_in_future", Map.of("date", date));
  }

  /**
   * Build a {@link ValidationError} for a date constraint violation where the date is not in the
   * past.
   *
   * @param field the field name
   * @param date the date value that is not in the past
   * @return a {@link ValidationError} with code "date.not_in_past" and parameter "date"
   */
  public static ValidationError buildDateNotInPastError(final String field, final Instant date) {
    return new ValidationError(field, "date.not_in_past", Map.of("date", date));
  }

  /**
   * Build a {@link ValidationError} for a date constraint violation where the date is not within a
   * specific range.
   *
   * @param field the field name
   * @param min the minimum date value in the range
   * @param max the maximum date value in the range
   * @return a {@link ValidationError} with code "date.not_in_range" and parameters "min" and "max"
   */
  public static ValidationError buildDateNotInRangeError(
      final String field, final Instant min, final Instant max) {
    return new ValidationError(field, "date.not_in_range", Map.of("min", min, "max", max));
  }

  /**
   * Build a {@link ValidationError} for a value mismatch constraint violation.
   *
   * @param field the field name
   * @param referField the name of the field that the value should match
   * @return a {@link ValidationError} with code "value.mismatch" and parameter "referField"
   */
  public static ValidationError buildValueMismatchError(
      final String field, final String referField) {
    return new ValidationError(field, "value.mismatch", Map.of("referField", referField));
  }
}
