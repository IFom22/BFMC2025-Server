package ee.taltech.carbackend.security.auth.controller.resource;

import lombok.Value;

@Value
public class RegisterRequest {

  String firstname;
  String lastname;
  String email;
  String password;
}
