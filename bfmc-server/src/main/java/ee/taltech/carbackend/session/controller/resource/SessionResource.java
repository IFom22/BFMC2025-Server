package ee.taltech.carbackend.session.controller.resource;

import java.time.Instant;
import java.util.UUID;
import lombok.Value;

@Value
public class SessionResource {

  UUID uuid;
  Instant createdAt;
}
