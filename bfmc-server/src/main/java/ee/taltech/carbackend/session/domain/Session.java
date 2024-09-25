package ee.taltech.carbackend.session.domain;

import ee.taltech.carbackend.session.enums.CompetitionType;
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
  private Instant ended;
  private CompetitionType competitionType;
}
