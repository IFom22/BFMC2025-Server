package ee.taltech.carbackend.security.domain;

import ee.taltech.carbackend.security.enums.Role;
import java.util.Collection;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Builder
public class User implements UserDetails {

  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private Role role;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
  }

  @Override
  public String getUsername() {
    return firstName + " " + lastName;
  }

  @Override
  public String getPassword() {
    return password;
  }
}
