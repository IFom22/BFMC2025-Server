package ee.taltech.carbackend.car.entity;

import static ee.taltech.carbackend.config.ServerServiceFlywayConfiguration.SCHEMA;

import ee.taltech.carbackend.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@Table(name = "car", schema = SCHEMA)
public class CarEntity extends BaseEntity {

  @Column(nullable = false, updatable = false)
  private UUID uuid;
  private String carName;
}
