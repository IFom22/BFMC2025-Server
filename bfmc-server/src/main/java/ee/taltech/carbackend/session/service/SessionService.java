package ee.taltech.carbackend.session.service;

import static java.util.UUID.randomUUID;

import ee.taltech.carbackend.session.domain.Session;
import ee.taltech.carbackend.session.repository.SessionRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionService {

  private final SessionRepository sessionRepository;

  private static void sendSessionUuidToCar() {
//    try (Jsonb jsonb = JsonbBuilder.create()) {
//      CarGeneralResource carGeneralResource = CarGeneralResource.builder()
//          .sessionUuid(SESSION_UUID)
//          .build();
//      SESSION.sendMessage(new TextMessage(jsonb.toJson(carGeneralResource)));
//    } catch (Exception exception) {
//      throw new RuntimeException(exception);
//    }
  }

  public Session createSession(Session session) {
    session.setUuid(randomUUID());
    Session savedSession = sessionRepository.createSession(session);

    sendSessionUuidToCar();

    return savedSession;
  }

  public void stopSession(UUID sessionUuid) {
    sessionRepository.stopSession(sessionUuid);
  }
}
