package com.dividingnumbersgame.game.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.RequestUpgradeStrategy;
import org.springframework.web.socket.server.standard.TomcatRequestUpgradeStrategy;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		RequestUpgradeStrategy upgradeStrategy = new TomcatRequestUpgradeStrategy();

		registry.addHandler(new ScheduledWebSocketHandler(),"/operation");

		registry
				.addHandler(new ScheduledWebSocketHandler(), "/operation")
				.setHandshakeHandler(new DefaultHandshakeHandler(upgradeStrategy))
				.setAllowedOrigins("*")
				.withSockJS();
	}
}