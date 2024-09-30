package ee.taltech.carbackend.session.service;

import static ee.taltech.carbackend.session.enums.SessionStatus.PAUSED;
import static ee.taltech.carbackend.session.enums.SessionStatus.RESTARTED;
import static ee.taltech.carbackend.session.enums.SessionStatus.STARTED;
import static ee.taltech.carbackend.session.enums.SessionStatus.STOPPED;
import static ee.taltech.carbackend.util.Constants.SESSION_UUID;
import static java.lang.String.format;
import static java.util.UUID.randomUUID;

import ee.taltech.carbackend.session.domain.Session;
import ee.taltech.carbackend.session.enums.SessionStatus;
import ee.taltech.carbackend.session.repository.SessionRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionService {

  private final SimpMessagingTemplate messagingTemplate;
  private final SessionRepository sessionRepository;

  public Session getSession() {
    return sessionRepository.getByUuid(SESSION_UUID);
  }

  public UUID createSession(Session session) {
    session.setUuid(randomUUID());
    session.setStatus(STARTED);
    Session savedSession = sessionRepository.save(session);

    sendStatusToCar(STARTED);

    SESSION_UUID = savedSession.getUuid();

    return SESSION_UUID;
  }

  public void pauseSession(UUID sessionUuid) {
    Session session = sessionRepository.getByUuid(sessionUuid);
    session.setStatus(PAUSED);
    sessionRepository.save(session);

    sendStatusToCar(PAUSED);
  }

  public void restartSession(UUID sessionUuid) {
    Session session = sessionRepository.getByUuid(sessionUuid);
    session.setStatus(RESTARTED);
    sessionRepository.save(session);

    sendStatusToCar(RESTARTED);
  }

  public void stopSession(UUID sessionUuid) {
    Session session = sessionRepository.getByUuid(sessionUuid);
    session.setStatus(STOPPED);
    sessionRepository.save(session);

    sendStatusToCar(STOPPED);

    SESSION_UUID = null;
  }

  private void sendStatusToCar(SessionStatus status) {
    messagingTemplate.convertAndSend("/topic/car-control", format("{\"status\":\"%s\"}", status));
  }
}
