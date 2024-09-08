package ee.taltech.carbackend.log.domain;

import ee.taltech.carbackend.session.domain.Session;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Log {

  private Long id;
  private UUID uuid;
  private Session session;
  private String message;
  private String classCreator;
  private String functionCreator;
}
