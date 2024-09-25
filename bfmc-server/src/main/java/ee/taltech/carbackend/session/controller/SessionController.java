package ee.taltech.carbackend.session.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

import ee.taltech.carbackend.session.controller.resource.SessionResource;
import ee.taltech.carbackend.session.domain.Session;
import ee.taltech.carbackend.session.mapper.SessionMapper;
import ee.taltech.carbackend.session.service.SessionService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/session", produces = APPLICATION_JSON_VALUE)
public class SessionController {

  private final SessionService sessionService;
  private final SessionMapper sessionMapper;

  @PostMapping("/start")
  public ResponseEntity<UUID> startSession(
      @RequestBody SessionResource sessionResource
  ) {
    Session session = sessionMapper.toDomain(sessionResource);
    session = sessionService.createSession(session);
    return ok(session.getUuid());
  }

  @PostMapping("/{sessionUuid}/stop")
  public ResponseEntity<String> stopSession(@PathVariable UUID sessionUuid) {
    sessionService.stopSession(sessionUuid);
    return ok("Session stopped");
  }
}
