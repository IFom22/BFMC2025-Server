package ee.taltech.carbackend.session.repository;

import static ee.taltech.carbackend.util.Constants.TEMP_CREATED_BY;
import static ee.taltech.carbackend.util.Constants.TEMP_MODIFIED_BY;

import ee.taltech.carbackend.session.domain.Session;
import ee.taltech.carbackend.session.entity.SessionEntity;
import ee.taltech.carbackend.session.mapper.SessionMapper;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SessionRepository {

  private final SessionJpaRepository sessionJpaRepository;
  private final SessionMapper sessionMapper;

  public Session getByUuid(UUID sessionUuid) {
    return sessionMapper.toDomain(sessionJpaRepository.findByUuid(sessionUuid));
  }

  public Session save(Session session) {
    SessionEntity sessionEntity = sessionMapper.toEntity(session);
    sessionEntity.setCreatedBy(TEMP_CREATED_BY);
    sessionEntity.setModifiedBy(TEMP_MODIFIED_BY);
    return sessionMapper.toDomain(sessionJpaRepository.save(sessionEntity));
  }
}
