package ee.taltech.carbackend.webrtc.domain;

import ee.taltech.carbackend.webrtc.enums.SessionStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignalMessage {

  private SessionStatus type;
  private String sender;
  private String receiver;
  private Object data;
}
