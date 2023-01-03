package br.com.omarcoteixeira.controller;

import br.com.omarcoteixeira.data.model.health.HealthStatus;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class HealthController {

  HealthStatus healthStatus;

  @GetMapping("/ping")
  Boolean ping() {
    return healthStatus.isHealthy();
  }
}
