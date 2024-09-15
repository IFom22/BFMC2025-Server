package ee.taltech.carbackend.session.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

import ee.taltech.carbackend.session.controller.resource.SessionResource;
import ee.taltech.carbackend.session.domain.Session;
import ee.taltech.carbackend.session.mapper.SessionMapper;
import ee.taltech.carbackend.session.service.SessionService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/session", produces = APPLICATION_JSON_VALUE)
public class SessionController {

  private final SessionService sessionService;
  private final SessionMapper sessionMapper;

  @GetMapping
  public ResponseEntity<List<SessionResource>> getSessions() {
    List<SessionResource> sessions = sessionMapper.toResource(sessionService.getAllSessions());
    return ok(sessions);
  }

  @PostMapping("/{carUuid}/create")
  public ResponseEntity<UUID> createSession(@PathVariable UUID carUuid) {
    Session session = sessionService.createSession(carUuid);
    return ok(session.getUuid());
  }
}
