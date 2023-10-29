package com.P3_OpenClassRoomBackEnd.services.messages;


import com.P3_OpenClassRoomBackEnd.models.MessagesModel;
import com.P3_OpenClassRoomBackEnd.models.RentalsModel;
import com.P3_OpenClassRoomBackEnd.models.UsersModel;
import com.P3_OpenClassRoomBackEnd.repository.MessagesRepository;
import com.P3_OpenClassRoomBackEnd.services.auth.AuthenticationService;
import com.P3_OpenClassRoomBackEnd.services.rental.GetRentalsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class PostMessagesServices {


    private final MessagesRepository messagesRepository;

    private final AuthenticationService authenticationService;

    private final GetRentalsServices getRentalsServices;
    public PostMessageResponse postMessage(PostMessageRequest request){

        UsersModel usersModel = authenticationService.retrieveUserById(request.getUser_id());
        RentalsModel rentalsModel = getRentalsServices.getOneRentalModel(request.getRental_id());
        var message = MessagesModel.builder()
                .message(request.getMessage())
                .rentalsModel(rentalsModel)
                .usersModel(usersModel)
                .created_at(new Date())
                .build();

        messagesRepository.save(message);

        return PostMessageResponse.builder().message("Message send with success").build();
    }
}
