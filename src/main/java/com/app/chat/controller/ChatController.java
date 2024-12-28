package com.app.chat.controller;

import com.app.chat.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    //this controller will handle the messages and broadcast it
    @MessageMapping("/sendMessage")
    //whenever a client send a message to this endpoint this method is revoked
    @SendTo("/topic/messages")
    //send message to those who are subscribed to this endpoint
    public ChatMessage sendMessage(ChatMessage message) {
        return message;
    }

    @GetMapping("chat")
    public String chat() {
        return "chat";
    }
}
