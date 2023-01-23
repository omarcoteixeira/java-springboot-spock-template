package br.com.omarcoteixeira.config;

import br.com.omarcoteixeira.data.dto.health.HealthStatusDto;
import java.util.concurrent.atomic.AtomicBoolean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HealthConfiguration {

  @Bean
  HealthStatusDto healthStatus(AtomicBoolean isHealthy, AtomicBoolean httpHealthy) {
    return new HealthStatusDto(isHealthy, httpHealthy);
  }
}
