package com.bravos.recruitment.libs.utils.exceptions;

/**
 * Stores standardized exception codes and default messages.
 */
public final class ExceptionConstant {

  private ExceptionConstant() {
  }

  public static final String BAD_REQUEST_CODE = "000001";
  public static final String BAD_REQUEST_MESSAGE = "Bad request.";

  public static final String CONFLICT_DATA_CODE = "000002";
  public static final String CONFLICT_DATA_MESSAGE = "Conflict data.";

  public static final String FORBIDDEN_CODE = "000003";
  public static final String FORBIDDEN_MESSAGE = "Forbidden.";

  public static final String NOT_FOUND_CODE = "000004";
  public static final String NOT_FOUND_MESSAGE = "Not found.";

  public static final String INTERNAL_ERROR_CODE = "000005";
  public static final String INTERNAL_ERROR_MESSAGE = "Internal server error.";

  public static final String TOO_MANY_REQUEST_CODE = "000006";
  public static final String TOO_MANY_REQUEST_MESSAGE = "Too many requests.";

  public static final String UNAUTHORIZE_CODE = "000007";
  public static final String UNAUTHORIZE_MESSAGE = "Unauthorized.";
}

