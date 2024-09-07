package ee.taltech.carbackend.session.repository;

import static ee.taltech.carbackend.util.Constants.TEMP_CREATED_BY;
import static ee.taltech.carbackend.util.Constants.TEMP_MODIFIED_BY;
import static java.time.Instant.now;
import static java.util.UUID.randomUUID;

import ee.taltech.carbackend.car.entity.CarEntity;
import ee.taltech.carbackend.car.repository.CarRepository;
import ee.taltech.carbackend.session.domain.Session;
import ee.taltech.carbackend.session.entity.SessionEntity;
import ee.taltech.carbackend.session.mapper.SessionMapper;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SessionRepository {

  private final SessionJpaRepository sessionJpaRepository;
  private final CarRepository carRepository;
  private final SessionMapper sessionMapper;

  public List<Session> findAll() {
    return sessionMapper.toDomain(sessionJpaRepository.findAll());
  }

  public Session findByUuid(UUID sessionUuid) {
    return sessionMapper.toDomain(sessionJpaRepository.findByUuid(sessionUuid));
  }

  public Session create(UUID carUuid) {
    CarEntity carEntity = carRepository.findByUuid(carUuid);

    SessionEntity sessionEntity = SessionEntity.builder()
        .uuid(randomUUID())
        .car(carEntity)
        .createdAt(now())
        .createdBy(TEMP_CREATED_BY)
        .modifiedBy(TEMP_MODIFIED_BY)
        .build();
    return sessionMapper.toDomain(sessionJpaRepository.save(sessionEntity));
  }
}
