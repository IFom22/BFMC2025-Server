package ee.taltech.carbackend.log.entity;

import static ee.taltech.carbackend.config.ServerServiceFlywayConfiguration.SCHEMA;

import ee.taltech.carbackend.common.entity.BaseEntity;
import ee.taltech.carbackend.session.entity.SessionEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "log", schema = SCHEMA)
public class LogEntity extends BaseEntity {

  @Column(nullable = false, updatable = false)
  private UUID uuid;
  @ManyToOne
  @JoinColumn(name = "session_id")
  private SessionEntity session;
  private String message;
  @Column(name = "class_сreator")
  private String classCreator;
  @Column(name = "function_сreator")
  private String functionCreator;
}