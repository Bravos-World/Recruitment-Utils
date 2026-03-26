package com.bravos.recruitment.libs.utils.exceptions;

/**
 * Exception for unauthenticated access attempts.
 */
public class UnauthorizeException extends BaseException {

  /**
   * Creates an exception with the default code and message.
   */
  public UnauthorizeException() {
    super(ExceptionConstant.UNAUTHORIZE_CODE, ExceptionConstant.UNAUTHORIZE_MESSAGE);
  }

  /**
   * Creates an exception with the provided code and default message.
   *
   * @param code application-specific error code
   */
  public UnauthorizeException(String code) {
    super(code, ExceptionConstant.UNAUTHORIZE_MESSAGE);
  }

  /**
   * Creates an exception with the provided code and message.
   *
   * @param code application-specific error code
   * @param message detailed error message
   */
  public UnauthorizeException(String code, String message) {
    super(code, message);
  }

  /**
   * Creates an exception with the provided code, message, and root cause.
   *
   * @param code application-specific error code
   * @param message detailed error message
   * @param cause underlying cause of the error
   */
  public UnauthorizeException(String code, String message, Throwable cause) {
    super(code, message, cause);
  }
}
