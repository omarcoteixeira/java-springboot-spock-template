package br.com.omarcoteixeira.data.model.metrics;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum MetricsEnum {
  IS_HEALTHY("is_healthy", "Is app healthy"),
  HTTP_HEALTHY("http_health", "Is http healthy");

  String name;
  String description;
}
