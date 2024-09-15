package ee.taltech.carbackend.security;

import ee.taltech.carbackend.config.MapperConfiguration;
import ee.taltech.carbackend.security.domain.User;
import ee.taltech.carbackend.security.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface UserMapper {

  User toDomain(UserEntity userEntity);

  UserEntity toEntity(User user);
}
