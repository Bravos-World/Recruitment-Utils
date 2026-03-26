package com.bravos.recruitment.libs.utils.utils;

import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.module.SimpleModule;
import tools.jackson.databind.ser.std.ToStringSerializer;

import java.math.BigInteger;

public class JsonUtils {

  private static final ObjectMapper OBJECT_MAPPER = buildObjectMapper();

  private JsonUtils() {
    // Utility class, prevent instantiation
  }

  public static ObjectMapper getObjectMapper() {
    return OBJECT_MAPPER;
  }

  private static ObjectMapper buildObjectMapper() {
    JsonMapper.Builder builder = JsonMapper.builder()
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        .disable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)
        .findAndAddModules();
    builder.addModule(longToStringModule());
    return builder.build();
  }

  private static SimpleModule longToStringModule() {
    SimpleModule module = new SimpleModule("LongToStringModule");
    module.addSerializer(Long.class, ToStringSerializer.instance);
    module.addSerializer(Long.TYPE, ToStringSerializer.instance);
    module.addSerializer(BigInteger.class, ToStringSerializer.instance);
    return module;
  }

}
