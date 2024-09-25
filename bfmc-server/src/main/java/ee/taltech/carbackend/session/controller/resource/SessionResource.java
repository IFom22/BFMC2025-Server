package ee.taltech.carbackend.session.controller.resource;

import ee.taltech.carbackend.session.enums.CompetitionType;
import java.time.Instant;
import lombok.Value;

@Value
public class SessionResource {

  Instant createdAt;
  CompetitionType competitionType;
}
