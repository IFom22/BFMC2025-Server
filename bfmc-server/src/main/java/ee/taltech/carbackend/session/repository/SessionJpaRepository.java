package ee.taltech.carbackend.session.repository;

import ee.taltech.carbackend.session.entity.SessionEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionJpaRepository extends JpaRepository<SessionEntity, Long> {

  SessionEntity findByUuid(UUID sessionUuid);
}
