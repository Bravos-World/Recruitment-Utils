package com.bravos.recruitment.libs.utils.models;

public record RApiResponse<T>(
    String code,
    T data,
    String message
) {
}
