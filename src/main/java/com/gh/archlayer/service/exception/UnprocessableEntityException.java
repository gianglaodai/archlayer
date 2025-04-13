package com.gh.archlayer.service.exception;

import java.io.Serial;
import java.util.Map;

public class UnprocessableEntityException extends ServiceException {
	@Serial
	private static final long serialVersionUID = -2389662250131624860L;

	protected UnprocessableEntityException(final String message, final String code, final Map<String, String> params, final Class<?> entityClass, final Throwable cause) {
		super(message, code, params, entityClass, cause);
	}

	@Override
	public ErrorCode getErrorCode() {
		return ErrorCode.UNPROCESSABLE_ENTITY;
	}

	public static class BusinessConstraintException extends UnprocessableEntityException {
		@Serial
		private static final long serialVersionUID = 2106637855063409061L;

		public BusinessConstraintException(final String message, final String code, final Map<String, String> params, final Class<?> entityClass, final Throwable cause) {
			super(message, code, params, entityClass, cause);
		}
	}

	public static class TemporalRuleException extends UnprocessableEntityException{
		@Serial
		private static final long serialVersionUID = 4908827765581949450L;

		public TemporalRuleException(final String message, final String code, final Map<String, String> params, final Class<?> entityClass, final Throwable cause) {
			super(message, code, params, entityClass, cause);
		}
	}

	public static class ResourceInUseException extends UnprocessableEntityException{
		@Serial
		private static final long serialVersionUID = 970544499712705532L;

		public ResourceInUseException(final String message, final String code, final Map<String, String> params, final Class<?> entityClass, final Throwable cause) {
			super(message, code, params, entityClass, cause);
		}
	}

	public static class ReferentialIntegrityViolationException extends UnprocessableEntityException{
		@Serial
		private static final long serialVersionUID = -2909014010149690508L;

		public ReferentialIntegrityViolationException(final String message, final String code, final Map<String, String> params, final Class<?> entityClass, final Throwable cause) {
			super(message, code, params, entityClass, cause);
		}
	}

	public static class InvalidStateException extends UnprocessableEntityException{
		@Serial
		private static final long serialVersionUID = 8817548717057172744L;

		protected InvalidStateException(final String message, final String code, final Map<String, String> params, final Class<?> entityClass, final Throwable cause) {
			super(message, code, params, entityClass, cause);
		}
	}

	public static class ImmutableFieldException extends UnprocessableEntityException {
		@Serial
		private static final long serialVersionUID = 2473482179557461133L;

		protected ImmutableFieldException(final String message, final String code, final Map<String, String> params, final Class<?> entityClass, final Throwable cause) {
			super(message, code, params, entityClass, cause);
		}
	}
}
