package com.P3_OpenClassRoomBackEnd.controllers;

import com.P3_OpenClassRoomBackEnd.services.messages.PostMessageRequest;
import com.P3_OpenClassRoomBackEnd.services.messages.PostMessageResponse;
import com.P3_OpenClassRoomBackEnd.services.messages.PostMessagesServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="messages")
@RequiredArgsConstructor
@Tag(name = "Message")
public class MessagesController {

    private final PostMessagesServices postMessagesServices;

    @PostMapping
    public ResponseEntity postMessage(@RequestBody PostMessageRequest request){
        return postMessagesServices.postMessage(request);
    }


}
