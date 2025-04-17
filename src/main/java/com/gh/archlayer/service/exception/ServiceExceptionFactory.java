package com.gh.archlayer.service.exception;

import com.gh.archlayer.service.validation.ValidationError;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/** Factory class for creating service exceptions. */
public final class ServiceExceptionFactory {

  private ServiceExceptionFactory() {}

  /**
   * Creates a new BadRequestException with the specified error key, parameters, and message.
   *
   * @param errorKey the error key associated with the bad request
   * @param params the parameters related to the exception
   * @param message the detailed message of the exception
   * @return a new instance of BadRequestException
   */
  public static BadRequestException newBadRequestException(
      final String errorKey, final Map<String, Serializable> params, final String message) {
    return new BadRequestException(errorKey, params, message);
  }

  /**
   * Creates a new ConflictException with the specified entity class, parameters, and message.
   *
   * @param entityClass the class of the entity that caused this exception
   * @param params the parameters associated with this exception
   * @param message the detailed message of the exception
   * @return a new instance of ConflictException
   */
  public static ConflictException newConflictException(
      final Class<?> entityClass, final Map<String, Serializable> params, final String message) {
    return new ConflictException(entityClass, params, message);
  }

  /**
   * Creates a new DuplicateUidException with the specified entity class, parameters, and message.
   *
   * @param entityClass the class of the entity that caused this exception
   * @param params the parameters associated with this exception
   * @param message the detailed message of the exception
   * @return a new instance of DuplicateUidException
   */
  public static ConflictException.DuplicateUidException newDuplicateUidException(
      final Class<?> entityClass, final Map<String, Serializable> params, final String message) {
    return new ConflictException.DuplicateUidException(entityClass, params, message);
  }

  /**
   * Creates a new ConcurrentModificationException with the specified entity class, parameters, and
   * message.
   *
   * @param entityClass the class of the entity that caused this exception
   * @param params the parameters associated with this exception
   * @param message the detailed message of the exception
   * @return a new instance of ConcurrentModificationException
   */
  public static ConflictException.ConcurrentModificationException
      newConcurrentModificationException(
          final Class<?> entityClass,
          final Map<String, Serializable> params,
          final String message) {
    return new ConflictException.ConcurrentModificationException(entityClass, params, message);
  }

  /**
   * Creates a new NotUniqueException with the specified entity class, parameters, and message.
   *
   * @param entityClass the class of the entity that caused this exception
   * @param params the parameters associated with this exception
   * @param message the detailed message of the exception
   * @return a new instance of NotUniqueException
   */
  public static ConflictException.NotUniqueException newNotUniqueException(
      final Class<?> entityClass, final Map<String, Serializable> params, final String message) {
    return new ConflictException.NotUniqueException(entityClass, params, message);
  }

  /**
   * Creates a new VersionMismatchException with the specified entity class, parameters, and
   * message.
   *
   * @param entityClass the class of the entity that caused this exception
   * @param params the parameters associated with this exception
   * @param message the detailed message of the exception
   * @return a new instance of VersionMismatchException
   */
  public static ConflictException.VersionMismatchException newVersionMismatchException(
      final Class<?> entityClass, final Map<String, Serializable> params, final String message) {
    return new ConflictException.VersionMismatchException(entityClass, params, message);
  }

  /**
   * Creates a new UnauthorizedException.
   *
   * @return a new instance of UnauthorizedException
   */
  public static UnauthorizedException newUnauthorizedException() {
    return new UnauthorizedException();
  }

  /**
   * Creates a new ForbiddenException with the specified entity class, parameters, and message.
   *
   * @param entityClass the class of the entity that caused this exception
   * @param params the parameters associated with this exception
   * @param message the detailed message of the exception
   * @return a new instance of ForbiddenException
   */
  public static ForbiddenException newForbiddenException(
      final Class<?> entityClass, final Map<String, Serializable> params, final String message) {
    return new ForbiddenException(entityClass, params, message);
  }

  /**
   * Creates a new InternalServerException with the specified message.
   *
   * @param message the detailed message of the exception
   * @return a new instance of InternalServerException
   */
  public static InternalServerException newInternalServerException(final String message) {
    return new InternalServerException(message);
  }

  /**
   * Creates a new NotFoundException with the specified entity class and id.
   *
   * @param entityClass the class of the entity that caused this exception
   * @param id the id of the entity that caused this exception
   * @return a new instance of NotFoundException
   */
  public static NotFoundException newNotFoundException(final Class<?> entityClass, final long id) {
    return new NotFoundException(Map.of("id", id), entityClass, id);
  }

  /**
   * Creates a new UnprocessableEntityException with the specified entity class, parameters, and
   * message.
   *
   * @param entityClass the class of the entity that caused this exception
   * @param params the parameters associated with this exception
   * @param message the detailed message of the exception
   * @return a new instance of UnprocessableEntityException
   */
  public static UnprocessableEntityException newUnprocessableEntityException(
      final Class<?> entityClass, final Map<String, Serializable> params, final String message) {
    return new UnprocessableEntityException(entityClass, params, message);
  }

  /**
   * Creates a new UnprocessableEntityException.ResourceInUseException with the specified entity
   * class and id.
   *
   * @param entityClass the class of the entity that caused this exception
   * @param id the id of the entity that caused this exception
   * @return a new instance of UnprocessableEntityException.ResourceInUseException
   */
  public static UnprocessableEntityException.ResourceInUseException newResourceInUseException(
      final Class<?> entityClass, final Object id) {
    return new UnprocessableEntityException.ResourceInUseException(entityClass, id);
  }

  /**
   * Creates a new UnprocessableEntityException.BusinessConstraintException with the specified
   * entity class, parameters, and message.
   *
   * @param entityClass the class of the entity that caused this exception
   * @param params the parameters associated with this exception
   * @param message the detailed message of the exception
   * @return a new instance of UnprocessableEntityException.BusinessConstraintException
   */
  public static UnprocessableEntityException.BusinessConstraintException
      newBusinessConstraintException(
          final Class<?> entityClass,
          final Map<String, Serializable> params,
          final String message) {
    return new UnprocessableEntityException.BusinessConstraintException(
        entityClass, params, message);
  }

  /**
   * Creates a new UnprocessableEntityException.ImmutableFieldException with the specified entity
   * class and field name.
   *
   * @param entityClass the class of the entity that caused this exception
   * @param fieldName the name of the field that caused this exception
   * @return a new instance of UnprocessableEntityException.ImmutableFieldException
   */
  public static UnprocessableEntityException.ImmutableFieldException newImmutableFieldException(
      final Class<?> entityClass, final String fieldName) {
    return new UnprocessableEntityException.ImmutableFieldException(entityClass, fieldName);
  }

  /**
   * Creates a new UnprocessableEntityException.InvalidStateException with the specified entity
   * class and message.
   *
   * @param entityClass the class of the entity that caused this exception
   * @param message the detailed message of the exception
   * @return a new instance of UnprocessableEntityException.InvalidStateException
   */
  public static UnprocessableEntityException.InvalidStateException newInvalidStateException(
      final Class<?> entityClass, final String message) {
    return new UnprocessableEntityException.InvalidStateException(entityClass, message);
  }

  /**
   * Creates a new UnprocessableEntityException.TemporalRuleException with the specified entity
   * class and rule name.
   *
   * @param entityClass the class of the entity that caused this exception
   * @param ruleName the name of the temporal rule that was violated
   * @return a new instance of UnprocessableEntityException.TemporalRuleException
   */
  public static UnprocessableEntityException.TemporalRuleException newTemporalRuleException(
      final Class<?> entityClass, final String ruleName) {
    return new UnprocessableEntityException.TemporalRuleException(entityClass, ruleName);
  }

  /**
   * Creates a new UnprocessableEntityException.MissingRequiredFieldException with the specified
   * entity class and field name.
   *
   * @param entityClass the class of the entity that caused this exception
   * @param fieldName the name of the field that caused this exception
   * @return a new instance of UnprocessableEntityException.MissingRequiredFieldException
   */
  public static UnprocessableEntityException.MissingRequiredFieldException
      newMissingRequiredFieldException(final Class<?> entityClass, final String fieldName) {
    return new UnprocessableEntityException.MissingRequiredFieldException(entityClass, fieldName);
  }

  /**
   * Creates a new UnprocessableEntityException.ReferentialIntegrityViolationException with the
   * specified entity class and relation name.
   *
   * @param entityClass the class of the entity that caused this exception
   * @param relationName the name of the relation that caused this exception
   * @return a new instance of UnprocessableEntityException.ReferentialIntegrityViolationException
   */
  public static UnprocessableEntityException.ReferentialIntegrityViolationException
      newReferentialIntegrityViolationException(
          final Class<?> entityClass, final String relationName) {
    return new UnprocessableEntityException.ReferentialIntegrityViolationException(
        entityClass, relationName);
  }

  /**
   * Creates a new ValidationException with the specified list of validation errors.
   *
   * @param errors the list of ValidationError objects that caused this exception
   * @return a new instance of ValidationException
   */
  public static ValidationException newValidationException(final List<ValidationError> errors) {
    return new ValidationException(errors);
  }
}
