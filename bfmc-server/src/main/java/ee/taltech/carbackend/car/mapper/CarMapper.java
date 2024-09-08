package ee.taltech.carbackend.car.mapper;

import ee.taltech.carbackend.car.domain.Car;
import ee.taltech.carbackend.car.entity.CarEntity;
import ee.taltech.carbackend.config.MapperConfiguration;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfiguration.class)
public interface CarMapper {

  Car toDomain(CarEntity carEntity);
}
