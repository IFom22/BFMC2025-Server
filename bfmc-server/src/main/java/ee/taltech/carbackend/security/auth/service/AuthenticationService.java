package ee.taltech.carbackend.security.auth.service;

import ee.taltech.carbackend.security.auth.controller.resource.AuthenticationRequest;
import ee.taltech.carbackend.security.auth.controller.resource.AuthenticationResource;
import ee.taltech.carbackend.security.auth.controller.resource.RegisterRequest;
import ee.taltech.carbackend.security.domain.User;
import ee.taltech.carbackend.security.enums.Role;
import ee.taltech.carbackend.security.repository.UserRepository;
import ee.taltech.carbackend.security.service.JwtService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResource register(RegisterRequest registerRequest) throws Exception {
    Optional<User> existedUser = userRepository.findByEmail(registerRequest.getEmail());

    if (existedUser.isPresent()) {
      throw new Exception("Email already exists");
    }

    User user = User.builder()
        .firstName(registerRequest.getFirstname())
        .lastName(registerRequest.getLastname())
        .email(registerRequest.getEmail())
        .password(passwordEncoder.encode(registerRequest.getPassword()))
        .role(Role.USER)
        .build();
    userRepository.save(user);

    String jwtToken = jwtService.generateToken(user);
    return AuthenticationResource.builder()
        .jwtToken(jwtToken)
        .build();
  }

  public AuthenticationResource authenticate(AuthenticationRequest registerRequest) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            registerRequest.getEmail(),
            registerRequest.getPassword()
        )
    );
    User user = userRepository.findByEmail(registerRequest.getEmail()).orElseThrow();
    String jwtToken = jwtService.generateToken(user);
    return AuthenticationResource.builder()
        .jwtToken(jwtToken)
        .build();
  }
}
