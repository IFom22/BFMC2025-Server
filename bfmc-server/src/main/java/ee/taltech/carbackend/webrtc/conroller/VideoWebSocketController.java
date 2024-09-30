package ee.taltech.carbackend.webrtc.conroller;

import static ee.taltech.carbackend.config.WebSocketSessionTracker.SESSION_MAP;

import ee.taltech.carbackend.webrtc.domain.SignalMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@MessageMapping("/video")
public class VideoWebSocketController {

  private final SimpMessagingTemplate messagingTemplate;

  @MessageMapping("/room")
  public void sendMessage(
      SignalMessage signalMessage,
      SimpMessageHeaderAccessor headerAccessor
  ) {
    String senderSessionId = headerAccessor.getSessionId();
    signalMessage.setSender(senderSessionId);
    String receiver = signalMessage.getReceiver();
    if (SESSION_MAP.containsKey(receiver)) {
      messagingTemplate.convertAndSendToUser(SESSION_MAP.get(receiver), "/room", signalMessage);
    }
  }
}
