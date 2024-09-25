package ee.taltech.carbackend.session.mapper;

import ee.taltech.carbackend.config.MapperConfiguration;
import ee.taltech.carbackend.session.controller.resource.SessionResource;
import ee.taltech.carbackend.session.domain.Session;
import ee.taltech.carbackend.session.entity.SessionEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface SessionMapper {

  List<Session> toDomain(List<SessionEntity> sessionEntities);

  Session toDomain(SessionEntity sessionEntity);

  Session toDomain(SessionResource sessionResource);
}
