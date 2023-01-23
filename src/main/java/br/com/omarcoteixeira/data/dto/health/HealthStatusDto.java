package br.com.omarcoteixeira.data.dto.health;

import java.util.concurrent.atomic.AtomicBoolean;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HealthStatusDto {

  AtomicBoolean isHealthy;
  AtomicBoolean httpHealthy;

  public boolean isHealthy() {
    isHealthy.set(httpHealthy.get());
    return isHealthy.get();
  }

  public void setHttpHealthy(boolean healthy) {
    httpHealthy.set(healthy);
  }
}
