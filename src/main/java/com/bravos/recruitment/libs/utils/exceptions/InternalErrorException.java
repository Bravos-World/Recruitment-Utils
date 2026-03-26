package com.bravos.recruitment.libs.utils.exceptions;

/**
 * Exception for unexpected server-side failures.
 */
public class InternalErrorException extends BaseException {

  /**
   * Creates an exception with the default code and message.
   */
  public InternalErrorException() {
    super(ExceptionConstant.INTERNAL_ERROR_CODE, ExceptionConstant.INTERNAL_ERROR_MESSAGE);
  }

  /**
   * Creates an exception with the provided code and default message.
   *
   * @param code application-specific error code
   */
  public InternalErrorException(String code) {
    super(code, ExceptionConstant.INTERNAL_ERROR_MESSAGE);
  }

  /**
   * Creates an exception with the provided code and message.
   *
   * @param code application-specific error code
   * @param message detailed error message
   */
  public InternalErrorException(String code, String message) {
    super(code, message);
  }

  /**
   * Creates an exception with the provided code, message, and root cause.
   *
   * @param code application-specific error code
   * @param message detailed error message
   * @param cause underlying cause of the error
   */
  public InternalErrorException(String code, String message, Throwable cause) {
    super(code, message, cause);
  }
}
