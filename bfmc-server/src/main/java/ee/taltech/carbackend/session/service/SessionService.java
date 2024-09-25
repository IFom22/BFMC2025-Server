package ee.taltech.carbackend.session.service;

import ee.taltech.carbackend.session.domain.Session;
import ee.taltech.carbackend.session.repository.SessionRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionService {

  private final SessionRepository sessionRepository;

  public Session createSession(Session session) {
    return sessionRepository.createSession(session);
  }

  public void stopSession(UUID sessionUuid) {
    sessionRepository.stopSession(sessionUuid);
  }
}
