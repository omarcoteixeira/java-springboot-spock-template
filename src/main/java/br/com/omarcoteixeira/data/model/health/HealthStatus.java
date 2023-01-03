package br.com.omarcoteixeira.data.model.health;

import java.util.concurrent.atomic.AtomicBoolean;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HealthStatus {

  private final AtomicBoolean isHealthy;
  private final AtomicBoolean httpHealthy;

  public boolean isHealthy() {
    isHealthy.set(httpHealthy.get());
    return isHealthy.get();
  }

  public void setHttpHealthy(boolean healthy) {
    httpHealthy.set(healthy);
  }
}
