# Recruitment Utils

Utility library for standardized API responses and reusable exceptions in Java/Spring Boot projects.

## Installation (JitPack)

Current release tag: `1.0.1`

### Gradle (Kotlin DSL)

```kotlin
repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.Bravos-World:Recruitment-Utils:1.0.1")
}
```

### Maven

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.Bravos-World</groupId>
        <artifactId>Recruitment-Utils</artifactId>
        <version>1.0.1</version>
    </dependency>
</dependencies>
```

## What this library provides

### Exceptions

- `BaseException` (abstract) with error `code`
- `BadRequestException`
- `ConflictDataException`
- `ForbiddenException`
- `NotFoundException`
- `InternalErrorException`
- `TooManyRequestException`
- `UnauthorizeException`
- `ExceptionConstant` for default codes/messages (`000001` - `000007`)

### Models

- `RApiResponse<T>`: standard API response payload
- `RPagination<T>`: pagination payload + `RPagination.empty()`
- `FieldError`: field-level validation error record

### `RApiResponse` factory methods

- `RApiResponse.of(code, data, message)`: full custom response
- `RApiResponse.ok(data)`: success response with code `000000`
- `RApiResponse.noContent()`: success response with no data
- `RApiResponse.error(code, message)`: error response with message

## Spring Boot usage

### 1) Throw library exceptions in your service

```java
package com.example.user;

import com.bravos.recruitment.libs.utils.exceptions.ExceptionConstant;
import com.bravos.recruitment.libs.utils.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  public UserDto getById(String id) {
    // Example only
    boolean userExists = false;

    if (!userExists) {
      throw new NotFoundException(
          ExceptionConstant.NOT_FOUND_CODE,
          "User with id " + id + " not found"
      );
    }

    return new UserDto(id, "john");
  }
}
```

### 2) Convert exceptions to consistent HTTP responses

```java
package com.example.shared;

import com.bravos.recruitment.libs.utils.exceptions.BaseException;
import com.bravos.recruitment.libs.utils.exceptions.ExceptionConstant;
import com.bravos.recruitment.libs.utils.models.RApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(BaseException.class)
  public ResponseEntity<RApiResponse<Void>> handleBaseException(BaseException ex) {
    HttpStatus status = mapStatus(ex.getCode());
    return ResponseEntity.status(status)
        .body(RApiResponse.error(ex.getCode(), ex.getMessage()));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<RApiResponse<Void>> handleUnknownException(Exception ex) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(RApiResponse.error(
            ExceptionConstant.INTERNAL_ERROR_CODE,
            ExceptionConstant.INTERNAL_ERROR_MESSAGE
        ));
  }

  private HttpStatus mapStatus(String code) {
    return switch (code) {
      case ExceptionConstant.BAD_REQUEST_CODE -> HttpStatus.BAD_REQUEST;
      case ExceptionConstant.CONFLICT_DATA_CODE -> HttpStatus.CONFLICT;
      case ExceptionConstant.FORBIDDEN_CODE -> HttpStatus.FORBIDDEN;
      case ExceptionConstant.NOT_FOUND_CODE -> HttpStatus.NOT_FOUND;
      case ExceptionConstant.TOO_MANY_REQUEST_CODE -> HttpStatus.TOO_MANY_REQUESTS;
      case ExceptionConstant.UNAUTHORIZE_CODE -> HttpStatus.UNAUTHORIZED;
      default -> HttpStatus.INTERNAL_SERVER_ERROR;
    };
  }
}
```

### 3) Return success response with `RApiResponse`

```java
package com.example.user;

import com.bravos.recruitment.libs.utils.models.RApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/users/{id}")
  public RApiResponse<UserDto> getUser(@PathVariable String id) {
    UserDto user = userService.getById(id);
    return RApiResponse.ok(user);
  }
}
```

Optional no-content endpoint:

```java
@DeleteMapping("/users/{id}")
public RApiResponse<Void> deleteUser(@PathVariable String id) {
  userService.delete(id);
  return RApiResponse.noContent();
}
```

### 4) Return paginated response with `RPagination`

```java
package com.example.user;

import com.bravos.recruitment.libs.utils.models.RApiResponse;
import com.bravos.recruitment.libs.utils.models.RPagination;
import java.util.List;

public class UserQueryService {

  public RApiResponse<RPagination<UserDto>> listUsers() {
    List<UserDto> items = List.of(new UserDto("1", "john"));
    RPagination<UserDto> page = new RPagination<>(items, 1, 1);

    return RApiResponse.of("000000", page, "Success");
  }
}
```

## Notes

- Exception code format follows `0000xx` in `ExceptionConstant`.
- `UnauthorizeException` name is intentionally kept to match the library API.
- You can use each exception no-args constructor for default code/message, or pass custom code/message as needed.


