package ee.taltech.carbackend.car.repository;

import static ee.taltech.carbackend.util.Constants.TEMP_CREATED_BY;
import static ee.taltech.carbackend.util.Constants.TEMP_MODIFIED_BY;

import ee.taltech.carbackend.car.domain.Car;
import ee.taltech.carbackend.car.entity.CarEntity;
import ee.taltech.carbackend.car.mapper.CarMapper;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CarRepository {

  private final CarJpaRepository jpaRepository;
  private final CarMapper carMapper;

  public CarEntity findByUuid(UUID carUuid) {
    return jpaRepository.findByUuid(carUuid);
  }

  public CarEntity save(Car car) {
    CarEntity carEntity = carMapper.toEntity(car);
    carEntity.setCreatedBy(TEMP_CREATED_BY);
    carEntity.setModifiedBy(TEMP_MODIFIED_BY);
    return jpaRepository.save(carEntity);
  }
}
