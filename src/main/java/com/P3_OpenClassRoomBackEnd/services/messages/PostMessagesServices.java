package com.P3_OpenClassRoomBackEnd.services.messages;


import com.P3_OpenClassRoomBackEnd.models.Message;
import com.P3_OpenClassRoomBackEnd.models.Rental;
import com.P3_OpenClassRoomBackEnd.models.User;
import com.P3_OpenClassRoomBackEnd.repository.MessagesRepository;
import com.P3_OpenClassRoomBackEnd.services.user.UserService;
import com.P3_OpenClassRoomBackEnd.services.rental.RentalServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostMessagesServices {


    private final MessagesRepository messagesRepository;

    private final UserService userService;

    private final RentalServices rentalServices;

    public ResponseEntity postMessage(PostMessageRequest request){
        Optional<User> user = userService.retrieveUserById(request.getUser_id());
        Optional<Rental> rental = rentalServices.getOneRentalModel(request.getRental_id());
        if(user.isPresent() && rental.isPresent()){
            Message message = Message.builder()
                    .message(request.getMessage())
                    .rental(rental.get())
                    .user(user.get())
                    .created_at(new Date())
                    .build();

            messagesRepository.save(message);

            return ResponseEntity
                    .ok(
                    PostMessageResponse
                            .builder()
                            .message("Message send with success")
                            .build());
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Error, verify data");

    }


}
