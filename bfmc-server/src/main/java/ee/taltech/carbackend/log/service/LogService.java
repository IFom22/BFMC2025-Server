package ee.taltech.carbackend.log.service;

import static java.util.UUID.randomUUID;

import ee.taltech.carbackend.log.domain.Log;
import ee.taltech.carbackend.log.repository.LogRepository;
import ee.taltech.carbackend.session.repository.SessionRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogService {

  private final LogRepository logRepository;
  private final SessionRepository sessionRepository;

  public List<Log> findAll() {
    return logRepository.findAll();
  }

  public List<Log> findAllBySessionUuid(UUID sessionUuid) {
    return logRepository.findBySessionUuid(sessionUuid);
  }

  public void createLog(UUID sessionUuid, Log log) {
    log.setUuid(randomUUID());
    log.setSession(sessionRepository.findByUuid(sessionUuid));
    logRepository.create(log);
  }
}
