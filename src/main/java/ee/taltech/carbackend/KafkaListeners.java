package ee.taltech.carbackend;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

  @KafkaListener(
      topics = "my-topic",
      groupId = "groupId"
  )
  void listener(String message) {
    System.out.println("Received: " + message);
  }
}
