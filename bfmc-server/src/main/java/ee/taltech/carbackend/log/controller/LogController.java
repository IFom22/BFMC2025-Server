package ee.taltech.carbackend.log.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;

import ee.taltech.carbackend.log.controller.resource.LogResource;
import ee.taltech.carbackend.log.mapper.LogMapper;
import ee.taltech.carbackend.log.service.LogService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/log", produces = APPLICATION_JSON_VALUE)
public class LogController {

  private final LogMapper logMapper;
  private final LogService logService;

  @GetMapping("/{sessionUuid}")
  public ResponseEntity<List<LogResource>> getLogs(@PathVariable UUID sessionUuid) {
    List<LogResource> logs = logMapper.toResource(logService.getLogs(sessionUuid));
    return ok(logs);
  }
}
