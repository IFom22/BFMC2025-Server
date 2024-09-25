package ee.taltech.carbackend.log.controller.resource;

import java.time.Instant;
import lombok.Value;

@Value
public class LogResource {

  String message;
  String createdInClass;
  String createdInFunction;
  Instant createdAt;
}