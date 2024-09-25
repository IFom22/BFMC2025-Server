package ee.taltech.carbackend.log.service;

import static java.util.Objects.nonNull;
import static java.util.UUID.randomUUID;

import ee.taltech.carbackend.log.domain.Log;
import ee.taltech.carbackend.log.repository.LogRepository;
import ee.taltech.carbackend.session.domain.Session;
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

  public List<Log> getLogs(UUID sessionUuid) {
    return logRepository.findLogs(sessionUuid);
  }

  public void createLog(UUID sessionUuid, Log log) {
    Session session = sessionRepository.findByUuid(sessionUuid);
    if (nonNull(session.getEnded())) {
      throw new RuntimeException("Ended session");
    }
    log.setUuid(randomUUID());
    log.setSession(session);
    logRepository.save(log);
  }
}
