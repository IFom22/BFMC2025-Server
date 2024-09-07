package ee.taltech.carbackend.session.entity;

import static ee.taltech.carbackend.config.ServerServiceFlywayConfiguration.SCHEMA;

import ee.taltech.carbackend.car.entity.CarEntity;
import ee.taltech.carbackend.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
  @ManyToOne
  @JoinColumn(name = "car_id")
  private CarEntity car;
  private Instant createdAt;
}
