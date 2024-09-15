package ee.taltech.carbackend.security.repository;


import static ee.taltech.carbackend.util.Constants.TEMP_CREATED_BY;
import static ee.taltech.carbackend.util.Constants.TEMP_MODIFIED_BY;

import ee.taltech.carbackend.security.UserMapper;
import ee.taltech.carbackend.security.domain.User;
import ee.taltech.carbackend.security.entity.UserEntity;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository {

  private final UserJpaRepository userJpaRepository;
  private final UserMapper userMapper;

  public Optional<User> findByEmail(String email) {
    return userJpaRepository.findByEmail(email).map(userMapper::toDomain);
  }

  public void save(User user) {
    UserEntity userEntity = userMapper.toEntity(user);
    userEntity.setCreatedBy(TEMP_CREATED_BY);
    userEntity.setModifiedBy(TEMP_MODIFIED_BY);
    userJpaRepository.save(userEntity);
  }
}
