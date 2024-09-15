package ee.taltech.carbackend.security.auth.controller;

import ee.taltech.carbackend.security.auth.controller.resource.AuthenticationRequest;
import ee.taltech.carbackend.security.auth.controller.resource.AuthenticationResource;
import ee.taltech.carbackend.security.auth.controller.resource.RegisterRequest;
import ee.taltech.carbackend.security.auth.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService authenticationService;

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResource> register(@RequestBody RegisterRequest request) throws Exception {
    return ResponseEntity.ok(authenticationService.register(request));
  }

  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResource> register(@RequestBody AuthenticationRequest request) {
    return ResponseEntity.ok(authenticationService.authenticate(request));
  }
}
