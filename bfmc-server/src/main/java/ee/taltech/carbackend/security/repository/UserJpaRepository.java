package ee.taltech.carbackend.security.repository;

import ee.taltech.carbackend.security.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

  Optional<UserEntity> findByEmail(String email);
}
