package ee.taltech.carbackend.config;

import static org.mapstruct.ReportingPolicy.IGNORE;

import org.mapstruct.MapperConfig;

@MapperConfig(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface MapperConfiguration {

}
