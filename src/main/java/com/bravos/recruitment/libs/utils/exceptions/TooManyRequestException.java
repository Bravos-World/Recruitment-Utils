package com.bravos.recruitment.libs.utils.exceptions;

/**
 * Exception for exceeded request rate limits.
 */
public class TooManyRequestException extends BaseException {

  /**
   * Creates an exception with the default code and message.
   */
  public TooManyRequestException() {
    super(ExceptionConstant.TOO_MANY_REQUEST_CODE, ExceptionConstant.TOO_MANY_REQUEST_MESSAGE);
  }

  /**
   * Creates an exception with the provided code and default message.
   *
   * @param code application-specific error code
   */
  public TooManyRequestException(String code) {
    super(code, ExceptionConstant.TOO_MANY_REQUEST_MESSAGE);
  }

  /**
   * Creates an exception with the provided code and message.
   *
   * @param code application-specific error code
   * @param message detailed error message
   */
  public TooManyRequestException(String code, String message) {
    super(code, message);
  }

  /**
   * Creates an exception with the provided code, message, and root cause.
   *
   * @param code application-specific error code
   * @param message detailed error message
   * @param cause underlying cause of the error
   */
  public TooManyRequestException(String code, String message, Throwable cause) {
    super(code, message, cause);
  }
}
