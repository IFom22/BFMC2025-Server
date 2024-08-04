package ee.taltech.carbackend.endpoints;

import ee.taltech.carbackend.MessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MessageController {

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  @GetMapping
  public String index() {
    return "Hello World";
  }

  @PostMapping("api/v1/message")
  public void publish(@RequestBody MessageRequest request) {
    kafkaTemplate.send("my-topic", request.message());
  }
}
