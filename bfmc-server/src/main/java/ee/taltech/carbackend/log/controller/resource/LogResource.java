package ee.taltech.carbackend.log.controller.resource;

import lombok.Value;

@Value
public class LogResource {

  String message;
  String classCreator;
  String functionCreator;
}