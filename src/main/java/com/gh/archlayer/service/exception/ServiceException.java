package com.gh.archlayer.service.exception;

import java.io.Serial;
import java.util.Map;

public abstract class ServiceException extends RuntimeException {
  @Serial private static final long serialVersionUID = 8757058442968326198L;
  private final String code;
  private final Map<String, String> params;
  private final Class<?> entityClass;

  protected ServiceException(
      final String message,
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final Throwable cause) {
    super(message, cause);
    this.code = code;
    this.entityClass = entityClass;
    this.params = Map.copyOf(params);
  }

  public abstract ErrorType getErrorType();

  public String getCode() {
    return code;
  }

  public Map<String, String> getParams() {
    return Map.copyOf(params);
  }

  public Class<?> getEntityClass() {
    return entityClass;
  }

  public static BadRequestException newBadRequestException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message) {
    return new BadRequestException(message, code, params, entityClass, null);
  }

  public static BadRequestException newBadRequestException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message,
      final Throwable cause) {
    return new BadRequestException(message, code, params, entityClass, cause);
  }

  public static UnprocessableEntityException newUnprocessableEntityException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message) {
    return new UnprocessableEntityException(message, code, params, entityClass, null);
  }

  public static UnprocessableEntityException newUnprocessableEntityException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message,
      final Throwable cause) {
    return new UnprocessableEntityException(message, code, params, entityClass, cause);
  }

  public static UnprocessableEntityException.BusinessConstraintException
      newBusinessConstraintException(
          final String code,
          final Map<String, String> params,
          final Class<?> entityClass,
          final String message) {
    return new UnprocessableEntityException.BusinessConstraintException(
        message, code, params, entityClass, null);
  }

  public static UnprocessableEntityException.BusinessConstraintException
      newBusinessConstraintException(
          final String code,
          final Map<String, String> params,
          final Class<?> entityClass,
          final String message,
          final Throwable cause) {
    return new UnprocessableEntityException.BusinessConstraintException(
        message, code, params, entityClass, cause);
  }

  public static UnprocessableEntityException.TemporalRuleException newTemporalRuleException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message) {
    return new UnprocessableEntityException.TemporalRuleException(
        message, code, params, entityClass, null);
  }

  public static UnprocessableEntityException.TemporalRuleException newTemporalRuleException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message,
      final Throwable cause) {
    return new UnprocessableEntityException.TemporalRuleException(
        message, code, params, entityClass, cause);
  }

  public static UnprocessableEntityException.ResourceInUseException newResourceInUseException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message) {
    return new UnprocessableEntityException.ResourceInUseException(
        message, code, params, entityClass, null);
  }

  public static UnprocessableEntityException.ResourceInUseException newResourceInUseException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message,
      final Throwable cause) {
    return new UnprocessableEntityException.ResourceInUseException(
        message, code, params, entityClass, cause);
  }

  public static UnprocessableEntityException.ReferentialIntegrityViolationException
      newReferentialIntegrityViolationException(
          final String code,
          final Map<String, String> params,
          final Class<?> entityClass,
          final String message) {
    return new UnprocessableEntityException.ReferentialIntegrityViolationException(
        message, code, params, entityClass, null);
  }

  public static UnprocessableEntityException.ReferentialIntegrityViolationException
      newReferentialIntegrityViolationException(
          final String code,
          final Map<String, String> params,
          final Class<?> entityClass,
          final String message,
          final Throwable cause) {
    return new UnprocessableEntityException.ReferentialIntegrityViolationException(
        message, code, params, entityClass, cause);
  }

  public static UnprocessableEntityException.InvalidStateException newInvalidStateException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message) {
    return new UnprocessableEntityException.InvalidStateException(
        message, code, params, entityClass, null);
  }

  public static UnprocessableEntityException.InvalidStateException newInvalidStateException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message,
      final Throwable cause) {
    return new UnprocessableEntityException.InvalidStateException(
        message, code, params, entityClass, cause);
  }

  public static UnprocessableEntityException.ImmutableFieldException newImmutableFieldException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message) {
    return new UnprocessableEntityException.ImmutableFieldException(
        message, code, params, entityClass, null);
  }

  public static UnprocessableEntityException.ImmutableFieldException newImmutableFieldException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message,
      final Throwable cause) {
    return new UnprocessableEntityException.ImmutableFieldException(
        message, code, params, entityClass, cause);
  }

  public static ConflictException newConflictException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message) {
    return new ConflictException(message, code, params, entityClass, null);
  }

  public static ConflictException newConflictException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message,
      final Throwable cause) {
    return new ConflictException(message, code, params, entityClass, cause);
  }

  public static ConflictException.DuplicateUidException newDuplicateUidException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message) {
    return new ConflictException.DuplicateUidException(message, code, params, entityClass, null);
  }

  public static ConflictException.DuplicateUidException newDuplicateUidException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message,
      final Throwable cause) {
    return new ConflictException.DuplicateUidException(message, code, params, entityClass, cause);
  }

  public static ConflictException.NotUniqueException newNotUniqueException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message) {
    return new ConflictException.NotUniqueException(message, code, params, entityClass, null);
  }

  public static ConflictException.NotUniqueException newNotUniqueException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message,
      final Throwable cause) {
    return new ConflictException.NotUniqueException(message, code, params, entityClass, cause);
  }

  public static ConflictException.VersionMismatchException newVersionMismatchException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message) {
    return new ConflictException.VersionMismatchException(message, code, params, entityClass, null);
  }

  public static ConflictException.VersionMismatchException newVersionMismatchException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message,
      final Throwable cause) {
    return new ConflictException.VersionMismatchException(
        message, code, params, entityClass, cause);
  }

  public static ConflictException.ConcurrentModificationException
      newConcurrentModificationException(
          final String code,
          final Map<String, String> params,
          final Class<?> entityClass,
          final String message) {
    return new ConflictException.ConcurrentModificationException(
        message, code, params, entityClass, null);
  }

  public static ConflictException.ConcurrentModificationException
      newConcurrentModificationException(
          final String code,
          final Map<String, String> params,
          final Class<?> entityClass,
          final String message,
          final Throwable cause) {
    return new ConflictException.ConcurrentModificationException(
        message, code, params, entityClass, cause);
  }

  public static NotFoundException newNotFoundException() {
    return newNotFoundException(null, Map.of(), null, null);
  }

  public static NotFoundException newNotFoundException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message) {
    return new NotFoundException(message, code, params, entityClass, null);
  }

  public static NotFoundException newNotFoundException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message,
      final Throwable cause) {
    return new NotFoundException(message, code, params, entityClass, cause);
  }

  public static ForbiddenException newForbiddenException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message) {
    return new ForbiddenException(message, code, params, entityClass, null);
  }

  public static ForbiddenException newForbiddenException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message,
      final Throwable cause) {
    return new ForbiddenException(message, code, params, entityClass, cause);
  }

  public static ForbiddenException.ResourceLockedException newResourceLockedException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message) {
    return new ForbiddenException.ResourceLockedException(message, code, params, entityClass, null);
  }

  public static ForbiddenException.ResourceLockedException newResourceLockedException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message,
      final Throwable cause) {
    return new ForbiddenException.ResourceLockedException(
        message, code, params, entityClass, cause);
  }

  public static ForbiddenException.OwnershipViolationException newOwnershipViolationException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message) {
    return new ForbiddenException.OwnershipViolationException(
        message, code, params, entityClass, null);
  }

  public static ForbiddenException.OwnershipViolationException newOwnershipViolationException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message,
      final Throwable cause) {
    return new ForbiddenException.OwnershipViolationException(
        message, code, params, entityClass, cause);
  }

  public static UnauthorizedException newUnauthorizedException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message) {
    return new UnauthorizedException(message, code, params, entityClass, null);
  }

  public static UnauthorizedException newUnauthorizedException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message,
      final Throwable cause) {
    return new UnauthorizedException(message, code, params, entityClass, cause);
  }

  public static InternalServerException newInternalServerException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message) {
    return new InternalServerException(message, code, params, entityClass, null);
  }

  public static InternalServerException newInternalServerException(
      final String code,
      final Map<String, String> params,
      final Class<?> entityClass,
      final String message,
      final Throwable cause) {
    return new InternalServerException(message, code, params, entityClass, cause);
  }
}
