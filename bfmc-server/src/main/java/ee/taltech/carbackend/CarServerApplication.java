package ee.taltech.carbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;

@SpringBootApplication(exclude = {SpringDataWebAutoConfiguration.class})
public class CarServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(CarServerApplication.class, args);
  }
}
