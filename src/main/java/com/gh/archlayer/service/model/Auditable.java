package com.gh.archlayer.service.model;

import java.time.Instant;

public interface Auditable {
  int getVersion();

  Instant getCreatedAt();

  Instant getUpdatedAt();
}
