package com.bravos.recruitment.libs.utils.exceptions;

/**
 * Exception for unauthorized access to protected resources.
 */
public class ForbiddenException extends BaseException {

  /**
   * Creates an exception with the default code and message.
   */
  public ForbiddenException() {
    super(ExceptionConstant.FORBIDDEN_CODE, ExceptionConstant.FORBIDDEN_MESSAGE);
  }

  /**
   * Creates an exception with the provided code and default message.
   *
   * @param code application-specific error code
   */
  public ForbiddenException(String code) {
    super(code, ExceptionConstant.FORBIDDEN_MESSAGE);
  }

  /**
   * Creates an exception with the provided code and message.
   *
   * @param code application-specific error code
   * @param message detailed error message
   */
  public ForbiddenException(String code, String message) {
    super(code, message);
  }

  /**
   * Creates an exception with the provided code, message, and root cause.
   *
   * @param code application-specific error code
   * @param message detailed error message
   * @param cause underlying cause of the error
   */
  public ForbiddenException(String code, String message, Throwable cause) {
    super(code, message, cause);
  }
}
