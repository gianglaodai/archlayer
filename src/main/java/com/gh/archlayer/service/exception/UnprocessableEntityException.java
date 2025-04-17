package com.gh.archlayer.service.exception;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

/** Represents an exception that occurs when an entity is in an invalid state. */
public class UnprocessableEntityException extends BadEntityException {
  @Serial private static final long serialVersionUID = -2389662250131624860L;

  /** Instantiates a new Unprocessable entity exception. */
  public UnprocessableEntityException(
      final Class<?> entityClass, final Map<String, Serializable> params, final String message) {
    super(entityClass, params, message);
  }

  /**
   * {@inheritDoc}
   *
   * @return {@link ErrorType#UNPROCESSABLE_ENTITY}
   */
  @Override
  public ErrorType getErrorType() {
    return ErrorType.UNPROCESSABLE_ENTITY;
  }

  @Override
  protected String getErrorKey() {
    return "unprocessable";
  }

  /** Represents an exception that occurs when a business constraint is violated. */
  public static class BusinessConstraintException extends UnprocessableEntityException {
    @Serial private static final long serialVersionUID = -8483660347475801688L;

    /** Instantiates a new BusinessConstraintException. */
    public BusinessConstraintException(
        final Class<?> entityClass, final Map<String, Serializable> params, final String message) {
      super(entityClass, params, message);
    }

    @Override
    protected String getErrorKey() {
      return "business_constraint";
    }
  }

  /** Represents an exception that occurs when a temporal rule is violated. */
  public static class TemporalRuleException extends UnprocessableEntityException {
    @Serial private static final long serialVersionUID = -8466850410170336356L;

    /** Instantiates a new TemporalRuleException. */
    public TemporalRuleException(final Class<?> entityClass, final String ruleName) {
      super(
          entityClass,
          Map.of("rule", ruleName),
          String.format("Temporal rule '%s' violated", ruleName));
    }

    @Override
    protected String getErrorKey() {
      return "temporal_rule_violation";
    }
  }

  /** Represents an exception that occurs when a resource is currently in use. */
  public static class ResourceInUseException extends UnprocessableEntityException {
    @Serial private static final long serialVersionUID = 8383913803881605956L;

    /** Instantiates a new ResourceInUseException. */
    public ResourceInUseException(final Class<?> entityClass, final Object id) {
      super(
          entityClass,
          Map.of("id", String.valueOf(id)),
          String.format(
              "Resource %s with id [%s] is currently in use", entityClass.getSimpleName(), id));
    }

    @Override
    protected String getErrorKey() {
      return "resource_in_use";
    }
  }

  /** Represents an exception that occurs when a referential integrity violation occurs. */
  public static class ReferentialIntegrityViolationException extends UnprocessableEntityException {
    @Serial private static final long serialVersionUID = -4654699584171817579L;

    /** Instantiates a new ReferentialIntegrityViolationException. */
    public ReferentialIntegrityViolationException(
        final Class<?> entityClass, final String relationName) {
      super(
          entityClass,
          Map.of("relation", relationName),
          String.format("Referential integrity violation on relation: %s", relationName));
    }

    @Override
    protected String getErrorKey() {
      return "referential_integrity";
    }
  }

  /** Represents an exception that occurs when an entity is in an invalid state. */
  public static class InvalidStateException extends UnprocessableEntityException {
    @Serial private static final long serialVersionUID = 1059824643991281764L;

    /** Instantiates a new InvalidStateException. */
    public InvalidStateException(final Class<?> entityClass, final String currentState) {
      super(
          entityClass,
          Map.of("state", currentState),
          String.format("Invalid state: %s for %s", currentState, entityClass.getSimpleName()));
    }

    @Override
    protected String getErrorKey() {
      return "invalid_state";
    }
  }

  /** Represents an exception that occurs when a field is immutable. */
  public static class ImmutableFieldException extends UnprocessableEntityException {

    @Serial private static final long serialVersionUID = -8561683912525314726L;

    /** Instantiates a new ImmutableFieldException. */
    public ImmutableFieldException(final Class<?> entityClass, final String fieldName) {
      super(
          entityClass,
          Map.of("field", fieldName),
          String.format("Field '%s' is immutable for %s", fieldName, entityClass.getSimpleName()));
    }

    @Override
    protected String getErrorKey() {
      return "immutable_field";
    }
  }

  /** Represents an exception that occurs when a required field is missing. */
  public static class MissingRequiredFieldException extends UnprocessableEntityException {
    @Serial private static final long serialVersionUID = 190420251002L;

    /** Instantiates a new MissingRequiredFieldException. */
    public MissingRequiredFieldException(final Class<?> entityClass, final String fieldName) {
      super(
          entityClass,
          Map.of("field", fieldName),
          String.format("Field '%s' is required for %s", fieldName, entityClass.getSimpleName()));
    }

    @Override
    protected String getErrorKey() {
      return "missing_required_field";
    }
  }
}
