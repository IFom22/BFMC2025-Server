package ee.taltech.carbackend.sensor.controller.resource;

import lombok.Value;

@Value
public class SensorResource {

  String value;
  String sensorName;
}