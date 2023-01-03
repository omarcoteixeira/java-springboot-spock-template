package br.com.omarcoteixeira.config;

import br.com.omarcoteixeira.data.model.metrics.MetricsEnum;
import io.micrometer.core.instrument.Metrics;
import java.util.concurrent.atomic.AtomicBoolean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfiguration {

  @Bean
  AtomicBoolean isHealthy() {
    var atomicBoolean = new AtomicBoolean();
    io.micrometer.core.instrument.Gauge.builder(
            MetricsEnum.IS_HEALTHY.getName(), atomicBoolean, b -> b.get() ? 1D : 0D)
        .description(MetricsEnum.IS_HEALTHY.getDescription())
        .register(Metrics.globalRegistry);
    return atomicBoolean;
  }

  @Bean
  AtomicBoolean httpHealthy() {
    var atomicBoolean = new AtomicBoolean();
    io.micrometer.core.instrument.Gauge.builder(
            MetricsEnum.HTTP_HEALTHY.getName(), atomicBoolean, b -> b.get() ? 1D : 0D)
        .description(MetricsEnum.HTTP_HEALTHY.getName())
        .register(Metrics.globalRegistry);
    return atomicBoolean;
  }
}
