package ee.taltech.carbackend.log.repository;

import ee.taltech.carbackend.log.entity.LogEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogJpaRepository extends JpaRepository<LogEntity, Long> {

  List<LogEntity> findAllBySessionUuid(UUID sessionUuid);
}
