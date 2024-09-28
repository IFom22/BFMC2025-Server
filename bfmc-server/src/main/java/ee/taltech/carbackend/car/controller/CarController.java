package ee.taltech.carbackend.car.controller;

import static org.springframework.http.ResponseEntity.ok;

import ee.taltech.carbackend.config.WebSocketSessionTracker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {

  private final WebSocketSessionTracker webSocketSessionTracker;

  @GetMapping()
  public ResponseEntity<Boolean> isCarActive() {
    return ok(webSocketSessionTracker.isRobotSessionActive());
  }
}
