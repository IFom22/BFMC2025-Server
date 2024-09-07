package ee.taltech.carbackend.session.service;

import ee.taltech.carbackend.session.domain.Session;
import ee.taltech.carbackend.session.repository.SessionRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionService {

  private final SessionRepository sessionRepository;

  public List<Session> getAllSessions() {
    return sessionRepository.findAll();
  }

  public Session createSession(UUID carUuid) {
    return sessionRepository.create(carUuid);
  }
}
