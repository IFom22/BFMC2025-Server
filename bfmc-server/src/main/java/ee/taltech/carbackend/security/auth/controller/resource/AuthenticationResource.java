package ee.taltech.carbackend.security.auth.controller.resource;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AuthenticationResource {

  String jwtToken;
}
