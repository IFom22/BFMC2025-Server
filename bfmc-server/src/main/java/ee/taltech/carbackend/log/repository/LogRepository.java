package ee.taltech.carbackend.log.repository;

import static ee.taltech.carbackend.util.Constants.TEMP_CREATED_BY;
import static ee.taltech.carbackend.util.Constants.TEMP_MODIFIED_BY;

import ee.taltech.carbackend.log.domain.Log;
import ee.taltech.carbackend.log.entity.LogEntity;
import ee.taltech.carbackend.log.mapper.LogMapper;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LogRepository {

  private final LogJpaRepository jpaRepository;
  private final LogMapper logMapper;

  public List<Log> findLogs(UUID sessionUuid) {
    return logMapper.toDomain(jpaRepository.findAllBySessionUuid(sessionUuid));
  }

  public Log save(Log log) {
    LogEntity logEntity = logMapper.toEntity(log);
    logEntity.setCreatedBy(TEMP_CREATED_BY);
    logEntity.setModifiedBy(TEMP_MODIFIED_BY);
    return logMapper.toDomain(jpaRepository.save(logEntity));
  }
}
