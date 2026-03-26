package com.bravos.recruitment.libs.utils.exceptions;

/**
 * Exception for invalid client request data.
 */
public class BadRequestException extends BaseException {

  /**
   * Creates an exception with the default code and message.
   */
  public BadRequestException() {
    super(ExceptionConstant.BAD_REQUEST_CODE, ExceptionConstant.BAD_REQUEST_MESSAGE);
  }

  /**
   * Creates an exception with the provided code and default message.
   *
   * @param code application-specific error code
   */
  public BadRequestException(String code) {
    super(code, ExceptionConstant.BAD_REQUEST_MESSAGE);
  }

  /**
   * Creates an exception with the provided code and message.
   *
   * @param code application-specific error code
   * @param message detailed error message
   */
  public BadRequestException(String code, String message) {
    super(code, message);
  }

  /**
   * Creates an exception with the provided code, message, and root cause.
   *
   * @param code application-specific error code
   * @param message detailed error message
   * @param cause underlying cause of the error
   */
  public BadRequestException(String code, String message, Throwable cause) {
    super(code, message, cause);
  }
}
