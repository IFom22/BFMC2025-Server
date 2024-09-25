package ee.taltech.carbackend.log.domain;

import ee.taltech.carbackend.session.domain.Session;
import java.time.Instant;
import java.util.UUID;
import lombok.Data;

@Data
public class Log {

  private Long id;
  private UUID uuid;
  private Session session;
  private String message;
  private String createdInClass;
  private String createdInFunction;
  private Instant createdAt;
}
