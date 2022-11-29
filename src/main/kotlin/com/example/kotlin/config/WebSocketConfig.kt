package com.example.kotlin.config

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer

@Configuration //설정파일을 의미하는 어노테이션
@EnableWebSocketMessageBroker// Websocket을 통한 메시징 기능을 활성화
class WebSocketConfig : WebSocketMessageBrokerConfigurer { // 인터페이스를 상속받아 아래 메서드들을 커스터마이징

    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry.addEndpoint("/ws").withSockJS() // Websocket 연결을 위한 엔드포인트를 지정
    }

    override fun configureMessageBroker(config: MessageBrokerRegistry) { // 메시지 주고 받을 엔드포인트에 대한 Prefix 지정
        config.setApplicationDestinationPrefixes("/app") // 서버가 목적지 일때(Client -> Server 메시지 전송시 Endpoint)
        config.enableSimpleBroker("/topic") // 클라이언트가 Subscribe 할떄(Server -> Client 메시지 전송 시 Endpoint)
    }
}