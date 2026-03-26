package com.bravos.recruitment.libs.utils.models;

public record RApiResponse<T>(
    String code,
    T data,
    String message
) {

  public static <T> RApiResponse<T> of(String code, T data, String message) {
    return new RApiResponse<>(code, data, message);
  }

  public static <T> RApiResponse<T> ok(T data) {
    return new RApiResponse<>(
        "000000",
        data,
        null
    );
  }

  public static <T> RApiResponse<T> noContent() {
    return new RApiResponse<>(
        "000000",
        null,
        null
    );
  }

  public static <T> RApiResponse<T> error(String code, String message) {
    return new RApiResponse<>(
        code,
        null,
        message
    );
  }

}
