package ee.taltech.carbackend.car.repository;

import ee.taltech.carbackend.car.entity.CarEntity;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CarRepository {

  private final CarJpaRepository jpaRepository;

  public CarEntity findByUuid(UUID carUuid) {
    return jpaRepository.findByUuid(carUuid);
  }
}
