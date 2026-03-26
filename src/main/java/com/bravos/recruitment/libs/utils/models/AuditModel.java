package com.bravos.recruitment.libs.utils.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public abstract class AuditModel {

  Long createdAt;

  Long updatedAt;

  Long createdBy;

  Long updatedBy;

}