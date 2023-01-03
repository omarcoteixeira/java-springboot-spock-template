package br.com.omarcoteixeira.config;

import br.com.omarcoteixeira.data.model.health.HealthStatus;
import java.util.concurrent.atomic.AtomicBoolean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HealthConfiguration {

  @Bean
  HealthStatus healthStatus(AtomicBoolean isHealthy, AtomicBoolean httpHealthy) {
    return new HealthStatus(isHealthy, httpHealthy);
  }
}
