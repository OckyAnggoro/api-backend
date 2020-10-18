package com.app.controller;

import com.app.model.ChatInMessage;
import com.app.service.UomService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;


@RestController
public class ChatController extends BaseController{


    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/guestchat")
    @SendTo("/topic/gueschats")
    public ChatInMessage handleMessaging(ChatInMessage message)throws Exception {
        Thread.sleep(1000);
        return new ChatInMessage(HtmlUtils.htmlEscape(message.getMessage()));
    }

    @MessageMapping("/guestupdate")
    @SendTo("/topic/guestupdates")
    public ChatInMessage handleUserTyping(ChatInMessage message)throws Exception {
        return new ChatInMessage("Someone is typing...");
    }

//    @MessageMapping("/guestjoin")
//    @SendTo("/topic/guestnames")
//    public ChatInMessage guestjoin(String data) throws  Exception {
//        Map<String, String> conditionMap = new HashMap<String, String>();
//        Gson gson = new Gson();
//        conditionMap = gson.fromJson(data, HashMap.class);
//        String message = "";
//        if(uomService.testChat(conditionMap.get("roomCode"))){
//            message = conditionMap.get("memberName");
//        }else{
//            message = "Code room is worng";
//        }
//        return new ChatInMessage(message);
//    }

    @MessageExceptionHandler
    @SendTo("/topic/errors")
    public String handleException(Throwable exception) {
        ChatInMessage error = new ChatInMessage("An error happened");
        return error.getMessage();
    }

    @MessageMapping("/chat/{roomId}/addUser")
    public void addUser(@DestinationVariable String roomId, @Payload ChatInMessage message, SimpMessageHeaderAccessor simpMessageHeaderAccessor){
        String currentRoomId = (String)simpMessageHeaderAccessor.getSessionAttributes().put("room_id", roomId);
        if(currentRoomId != null){
            ChatInMessage leaveMessage = new ChatInMessage();
            leaveMessage.setChatInMessageType(ChatInMessage.ChatInMessageType.LEAVE);
            leaveMessage.setSenderName(message.getSenderName());
            simpMessagingTemplate.convertAndSend("/topic/guestNames/" + currentRoomId, leaveMessage);
        }
        simpMessageHeaderAccessor.getSessionAttributes().put("name", message.getSenderName());
        simpMessagingTemplate.convertAndSend("/topic/guestNames/" + roomId, message);
    }

    @MessageMapping("/chat/{roomId}/sendMessage")
    public void sendMessage(@DestinationVariable String roomId, @Payload ChatInMessage message) throws InterruptedException {
        Thread.sleep(100);
        simpMessagingTemplate.convertAndSend("/topic/messageReceive/" + roomId, message);
    }
}

