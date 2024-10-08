package ee.taltech.carbackend.log.mapper;

import ee.taltech.carbackend.config.MapperConfiguration;
import ee.taltech.carbackend.log.controller.resource.LogResource;
import ee.taltech.carbackend.log.domain.Log;
import ee.taltech.carbackend.log.entity.LogEntity;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface LogMapper {

  Log toDomain(LogEntity entity);

  List<Log> toDomain(List<LogEntity> entities);

  Log toDomain(LogResource resource);

  LogEntity toEntity(Log domain);

  LogResource toResource(Log domain);

  List<LogResource> toResource(List<Log> domain);
}
