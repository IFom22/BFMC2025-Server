package ee.taltech.carbackend.session.repository;

import static ee.taltech.carbackend.util.Constants.TEMP_CREATED_BY;
import static ee.taltech.carbackend.util.Constants.TEMP_MODIFIED_BY;
import static java.time.Instant.now;
import static java.util.UUID.randomUUID;

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

  public Session findByUuid(UUID sessionUuid) {
    return sessionMapper.toDomain(sessionJpaRepository.findByUuid(sessionUuid));
  }

  public Session createSession(Session session) {
    SessionEntity sessionEntity = SessionEntity.builder()
        .uuid(randomUUID())
        .createdAt(session.getCreatedAt())
        .competitionType(session.getCompetitionType())
        .createdBy(TEMP_CREATED_BY)
        .modifiedBy(TEMP_MODIFIED_BY)
        .build();
    return sessionMapper.toDomain(sessionJpaRepository.save(sessionEntity));
  }

  public void stopSession(UUID sessionUuid) {
    SessionEntity sessionEntity = sessionJpaRepository.findByUuid(sessionUuid);
    sessionEntity.setEnded(now());
    sessionJpaRepository.save(sessionEntity);
  }
}
