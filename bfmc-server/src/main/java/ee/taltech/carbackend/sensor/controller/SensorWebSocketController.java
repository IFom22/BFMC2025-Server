package ee.taltech.carbackend.sensor.controller;

import static org.springframework.http.ResponseEntity.ok;

import ee.taltech.carbackend.sensor.controller.resource.SensorResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
@MessageMapping("/sensor")
public class SensorWebSocketController {

  @MessageMapping("/create")
  @SendTo("/topic/sensor")
  public ResponseEntity<SensorResource> createLog(
      @RequestBody SensorResource sensorResource
  ) {
    return ok(sensorResource);
  }
}
