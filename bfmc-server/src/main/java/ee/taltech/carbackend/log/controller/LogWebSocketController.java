package ee.taltech.carbackend.log.controller;

import static org.springframework.http.ResponseEntity.ok;

import ee.taltech.carbackend.log.controller.resource.LogResource;
import ee.taltech.carbackend.log.domain.Log;
import ee.taltech.carbackend.log.mapper.LogMapper;
import ee.taltech.carbackend.log.service.LogService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
@MessageMapping("/log")
public class LogWebSocketController {

  private final LogMapper logMapper;
  private final LogService logService;

  @MessageMapping("/create")
  public ResponseEntity<LogResource> createLog(
      @RequestBody LogResource logResource
  ) {
    Log log = logMapper.toDomain(logResource);
    LogResource response = logMapper.toResource(
        logService.createLog(
            UUID.fromString("b2ff7905-0275-4f1b-8a9b-76c17bad95fd"),
            log
        ));
    return ok(response);
  }
}

