package com.P3_OpenClassRoomBackEnd.controllers;

import com.P3_OpenClassRoomBackEnd.services.messages.PostMessageRequest;
import com.P3_OpenClassRoomBackEnd.services.messages.PostMessageResponse;
import com.P3_OpenClassRoomBackEnd.services.messages.PostMessagesServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="messages")
@RequiredArgsConstructor
public class MessagesController {

    private final PostMessagesServices postMessagesServices;
    @PostMapping
    public PostMessageResponse postMessage(@RequestBody PostMessageRequest request){
        return postMessagesServices.postMessage(request);
    }
}
