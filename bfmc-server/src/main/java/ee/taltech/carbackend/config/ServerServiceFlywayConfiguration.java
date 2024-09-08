package ee.taltech.carbackend.config;

import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerServiceFlywayConfiguration {

  public static final String SCHEMA = "server";

  @Bean
  public Flyway serverServiceFlyway(
      DataSource dataSource,
      @Value("true") Boolean cleanDisabled
  ) {
    return new Flyway(
        new FluentConfiguration()
            .cleanDisabled(cleanDisabled)
            .locations("db/bfmc-server-migration")
            .schemas(SCHEMA)
            .outOfOrder(true)
            .ignoreMigrationPatterns("*:missing", "*:future")
            .dataSource(dataSource)
    );
  }

  @Bean
  public FlywayMigrationInitializer serverServiceFlywayInitializer(
      Flyway serverServiceFlyway,
      ObjectProvider<FlywayMigrationStrategy> migrationStrategy
  ) {
    return new FlywayMigrationInitializer(serverServiceFlyway, migrationStrategy.getIfAvailable());
  }
}
