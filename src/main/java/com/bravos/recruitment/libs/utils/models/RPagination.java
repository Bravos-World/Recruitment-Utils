package com.bravos.recruitment.libs.utils.models;

import java.util.Collection;
import java.util.List;

public record RPagination<T>(
    Collection<T> items,
    long totalItems,
    int totalPages
) {

  private static final RPagination<?> EMPTY = new RPagination<>(List.of(), 0, 0);

  public static <T> RPagination<T> empty() {
    @SuppressWarnings("unchecked")
    RPagination<T> empty = (RPagination<T>) EMPTY;
    return empty;
  }

}
