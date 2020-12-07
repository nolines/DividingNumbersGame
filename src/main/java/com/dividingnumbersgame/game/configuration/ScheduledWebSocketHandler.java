package com.dividingnumbersgame.game.configuration;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ScheduledWebSocketHandler extends TextWebSocketHandler {
 
  private List<WebSocketSession> activeSessions = new CopyOnWriteArrayList<>();
 
  @Override
  public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
    System.out.println("qweqwe");
    activeSessions.forEach(session1 -> {
      try {
        if (!session1.equals(session)) {
          session.sendMessage(message);
          System.out.println("Message from Client received: " + message);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
  }
 
  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    activeSessions.add(session);
  }
 
  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    activeSessions.remove(session);
  }
}