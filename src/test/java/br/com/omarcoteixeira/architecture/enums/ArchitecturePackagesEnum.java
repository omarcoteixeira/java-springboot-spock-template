package br.com.omarcoteixeira.architecture.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ArchitecturePackagesEnum {
  BASE_PACKAGE("br.com.omarcoteixeira");

  String value;
}
