package ee.taltech.carbackend.car.repository;

import ee.taltech.carbackend.car.entity.CarEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarJpaRepository extends JpaRepository<CarEntity, Long> {

  CarEntity findByUuid(UUID carUuid);
}
