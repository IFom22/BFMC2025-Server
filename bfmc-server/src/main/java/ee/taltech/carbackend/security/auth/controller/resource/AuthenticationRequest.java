package ee.taltech.carbackend.security.auth.controller.resource;

import lombok.Value;

@Value
public class AuthenticationRequest {

  String email;
  String password;
}
