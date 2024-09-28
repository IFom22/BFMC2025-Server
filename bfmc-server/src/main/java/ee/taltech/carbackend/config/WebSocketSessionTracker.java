package ee.taltech.carbackend.config;

import java.util.Objects;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocketSessionTracker {

  private String robotSessionId = "";
  private String robotId = "";

  @EventListener
  public void handleWebSocketConnectListener(SessionConnectEvent event) {
    StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
    String sessionId = headerAccessor.getSessionId();
    String nativeHeader = headerAccessor.getFirstNativeHeader("robotId");

    if (nativeHeader != null) {
      robotSessionId = sessionId;
      robotId = nativeHeader;
    }
  }

  @EventListener
  public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
    StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
    String sessionId = headerAccessor.getSessionId();

    if (Objects.equals(sessionId, robotSessionId)) {
      robotSessionId = "";
      robotId = "";
    }
  }

  public boolean isRobotSessionActive() {
    return !robotId.isEmpty();
  }
}
