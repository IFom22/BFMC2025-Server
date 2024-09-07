package ee.taltech.carbackend.car.domain;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Car {

  Long id;
  UUID uuid;
  String carName;
}
