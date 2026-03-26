package com.bravos.recruitment.libs.utils.exceptions;

/**
 * Exception for data conflicts during processing.
 */
public class ConflictDataException extends BaseException {

  /**
   * Creates an exception with the default code and message.
   */
  public ConflictDataException() {
    super(ExceptionConstant.CONFLICT_DATA_CODE, ExceptionConstant.CONFLICT_DATA_MESSAGE);
  }

  /**
   * Creates an exception with the provided code and default message.
   *
   * @param code application-specific error code
   */
  public ConflictDataException(String code) {
    super(code, ExceptionConstant.CONFLICT_DATA_MESSAGE);
  }

  /**
   * Creates an exception with the provided code and message.
   *
   * @param code application-specific error code
   * @param message detailed error message
   */
  public ConflictDataException(String code, String message) {
    super(code, message);
  }

  /**
   * Creates an exception with the provided code, message, and root cause.
   *
   * @param code application-specific error code
   * @param message detailed error message
   * @param cause underlying cause of the error
   */
  public ConflictDataException(String code, String message, Throwable cause) {
    super(code, message, cause);
  }
}
