package ee.taltech.carbackend.session.domain;

import ee.taltech.carbackend.session.enums.CompetitionType;
import ee.taltech.carbackend.session.enums.SessionStatus;
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
  private SessionStatus sessionStatus;
  private CompetitionType competitionType;
}
