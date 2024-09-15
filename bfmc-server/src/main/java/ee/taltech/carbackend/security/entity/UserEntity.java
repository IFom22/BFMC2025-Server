package ee.taltech.carbackend.security.entity;

import static ee.taltech.carbackend.config.ServerServiceFlywayConfiguration.SCHEMA;

import ee.taltech.carbackend.common.entity.BaseEntity;
import ee.taltech.carbackend.security.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "_user", schema = SCHEMA)
public class UserEntity extends BaseEntity {

  String firstName;
  String lastName;
  String email;
  String password;
  @Enumerated(EnumType.STRING)
  Role role;
}
