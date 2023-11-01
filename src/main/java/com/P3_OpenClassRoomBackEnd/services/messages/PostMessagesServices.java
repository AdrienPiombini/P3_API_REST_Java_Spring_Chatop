package com.P3_OpenClassRoomBackEnd.services.messages;


import com.P3_OpenClassRoomBackEnd.models.Message;
import com.P3_OpenClassRoomBackEnd.models.Rental;
import com.P3_OpenClassRoomBackEnd.models.User;
import com.P3_OpenClassRoomBackEnd.repository.MessagesRepository;
import com.P3_OpenClassRoomBackEnd.services.user.UserService;
import com.P3_OpenClassRoomBackEnd.services.rental.RentalServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class PostMessagesServices {


    private final MessagesRepository messagesRepository;

    private final UserService userService;

    private final RentalServices rentalServices;
    public PostMessageResponse postMessage(PostMessageRequest request){
        User user = userService.retrieveUserById(request.getUser_id());
        Rental rental = rentalServices.getOneRentalModel(request.getRental_id());
        var message = Message.builder()
                .message(request.getMessage())
                .rental(rental)
                .user(user)
                .created_at(new Date())
                .build();

        messagesRepository.save(message);

        return PostMessageResponse.builder().message("Message send with success").build();
    }
}
