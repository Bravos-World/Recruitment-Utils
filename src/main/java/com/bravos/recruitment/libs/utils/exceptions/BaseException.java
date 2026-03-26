package com.bravos.recruitment.libs.utils.exceptions;

import lombok.Getter;

public abstract class BaseException extends RuntimeException {

  @Getter
  private final String code;

  protected BaseException(String code) {
    super();
    this.code = code;
  }

  protected BaseException(String code, String message) {
    super(message);
    this.code = code;
  }

  protected BaseException(String code, String message, Throwable cause) {
    super(message, cause);
    this.code = code;
  }

}
