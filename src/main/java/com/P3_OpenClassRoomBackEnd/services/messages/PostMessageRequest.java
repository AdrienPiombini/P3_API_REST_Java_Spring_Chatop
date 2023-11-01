package com.P3_OpenClassRoomBackEnd.services.messages;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostMessageRequest {
    private String message;
    private Integer user_id;
    private Integer rental_id;
}
