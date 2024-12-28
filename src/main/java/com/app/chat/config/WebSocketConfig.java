package com.app.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker
//message broker is kind of a middle man that will direct the message in the right way
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
//web socket enables real time communication and stomp tells how to route the messages

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat")
                .setAllowedOrigins("http://localhost:8080")
                .withSockJS();
         }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
       //set message broker
        registry.enableSimpleBroker("/topic");
        //expect message with /app/sendmessage
        registry.setApplicationDestinationPrefixes("/app");

    }
}
