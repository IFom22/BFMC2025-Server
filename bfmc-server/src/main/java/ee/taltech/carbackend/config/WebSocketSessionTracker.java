package ee.taltech.carbackend.config;

import ee.taltech.carbackend.webrtc.domain.SignalMessage;
import ee.taltech.carbackend.webrtc.enums.SessionStatus;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@RequiredArgsConstructor
public class WebSocketSessionTracker {

  public static final Map<String, String> SESSION_MAP = new ConcurrentHashMap<>();
  private final SimpMessagingTemplate messagingTemplate;
  private String robotSessionId = "";
  private String robotId = "";

  @EventListener
  public void handleWebSocketConnectListener(SessionConnectEvent event) {
    StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
    String sessionId = headerAccessor.getSessionId();
    String nativeHeader = headerAccessor.getFirstNativeHeader("robotId");
    String userUuid = headerAccessor.getFirstNativeHeader("userUuid");

    if (nativeHeader != null) {
      robotSessionId = sessionId;
      robotId = nativeHeader;
    }

    sendSignalToUsers(SessionStatus.INIT, sessionId);

    SESSION_MAP.put(sessionId, userUuid);
  }

  @EventListener
  public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
    StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
    String sessionId = headerAccessor.getSessionId();

    if (Objects.equals(sessionId, robotSessionId)) {
      robotSessionId = "";
      robotId = "";
    }

    sendSignalToUsers(SessionStatus.LOGOUT, sessionId);

    SESSION_MAP.remove(sessionId);
  }

  private void sendSignalToUsers(SessionStatus sessionStatus, String sessionId) {
    SignalMessage signalMessage = SignalMessage.builder()
        .type(sessionStatus)
        .sender(sessionId)
        .build();

    messagingTemplate.convertAndSend("/topic/room", signalMessage);
  }

  public boolean isRobotSessionActive() {
    return !robotId.isEmpty();
  }
}