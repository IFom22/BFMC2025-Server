package ee.taltech.carbackend.session.entity;

import static ee.taltech.carbackend.config.ServerServiceFlywayConfiguration.SCHEMA;
import static jakarta.persistence.EnumType.STRING;

import ee.taltech.carbackend.common.entity.BaseEntity;
import ee.taltech.carbackend.session.enums.CompetitionType;
import ee.taltech.carbackend.session.enums.SessionStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.UUID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "session", schema = SCHEMA)
public class SessionEntity extends BaseEntity {

  @Column(nullable = false, updatable = false)
  private UUID uuid;
  private Instant createdAt;
  @Enumerated(STRING)
  private SessionStatus status;
  @Enumerated(STRING)
  private CompetitionType competitionType;
}
