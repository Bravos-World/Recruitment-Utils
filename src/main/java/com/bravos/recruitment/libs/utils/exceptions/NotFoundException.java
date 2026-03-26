package com.bravos.recruitment.libs.utils.exceptions;

/**
 * Exception for missing resources.
 */
public class NotFoundException extends BaseException {

  /**
   * Creates an exception with the default code and message.
   */
  public NotFoundException() {
    super(ExceptionConstant.NOT_FOUND_CODE, ExceptionConstant.NOT_FOUND_MESSAGE);
  }

  /**
   * Creates an exception with the provided code and default message.
   *
   * @param code application-specific error code
   */
  public NotFoundException(String code) {
    super(code, ExceptionConstant.NOT_FOUND_MESSAGE);
  }

  /**
   * Creates an exception with the provided code and message.
   *
   * @param code application-specific error code
   * @param message detailed error message
   */
  public NotFoundException(String code, String message) {
    super(code, message);
  }

  /**
   * Creates an exception with the provided code, message, and root cause.
   *
   * @param code application-specific error code
   * @param message detailed error message
   * @param cause underlying cause of the error
   */
  public NotFoundException(String code, String message, Throwable cause) {
    super(code, message, cause);
  }
}
