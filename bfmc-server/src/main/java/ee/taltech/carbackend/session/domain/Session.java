package ee.taltech.carbackend.session.domain;

import java.time.Instant;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Session {

  private Long id;
  private UUID uuid;
  private Instant createdAt;
}
